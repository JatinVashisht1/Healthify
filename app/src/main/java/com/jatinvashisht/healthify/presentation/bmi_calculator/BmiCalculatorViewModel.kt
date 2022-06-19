package com.jatinvashisht.healthify.presentation.bmi_calculator

import androidx.compose.runtime.mutableStateOf
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jatinvashisht.healthify.presentation.bmi_calculator.components.BmiCalculatorScreenState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlin.math.pow

@HiltViewModel
class BmiCalculatorViewModel @Inject constructor() : ViewModel() {

    val uiEvents = Channel<UiEvents>()

    private val bmiCalculatorScreenState = mutableStateOf<BmiCalculatorScreenState>(
        BmiCalculatorScreenState()
    )
    val bmiCalculatorScreen = bmiCalculatorScreenState

    fun onScreenEventFired(event: BmiCalculatorScreenEvents) {
        when (event) {
            BmiCalculatorScreenEvents.AdultRadioButtonClicked -> bmiCalculatorScreenState.value =
                bmiCalculatorScreenState.value.copy(isAdult = true)

            BmiCalculatorScreenEvents.ChildRadioButtonClicked -> bmiCalculatorScreenState.value =
                bmiCalculatorScreenState.value.copy(isAdult = false)

            is BmiCalculatorScreenEvents.HeightTextFieldValueChanged -> bmiCalculatorScreenState.value =
                bmiCalculatorScreenState.value.copy(height = event.newValue, result = "", weightStatus = "")

            is BmiCalculatorScreenEvents.WeightTextFieldValueChanged -> bmiCalculatorScreenState.value =
                bmiCalculatorScreenState.value.copy(weight = event.newValue, result = "", weightStatus = "")

            BmiCalculatorScreenEvents.CalculateBmiButtonClicked -> {
                val heightTextFieldValue = bmiCalculatorScreenState.value.height
                val weightTextFieldValue = bmiCalculatorScreenState.value.weight

                if (heightTextFieldValue.trim().isNotBlank() and weightTextFieldValue.trim()
                        .isNotBlank()
                ) {
                    try {
                        val result =
                            weightTextFieldValue.toDouble() / heightTextFieldValue.toDouble().pow(2)

                        val resultString = String.format("%.2f",result)

                        bmiCalculatorScreenState.value =
                            bmiCalculatorScreenState.value.copy(result = resultString, weightStatus = getWeightStatus(resultString))
                        sendUiEvent(UiEvents.CalculationSuccessful)
                    } catch (e: Exception) {
                        sendUiEvent(UiEvents.ShowSnackbar("Enter correct values of height and weight"))
                    }
                } else {
                    sendUiEvent(UiEvents.ShowSnackbar("Height and weight cannot be empty"))
                }
            }
        }
    }

    /**
     * Below 18.5	Underweight
    18.5 – 24.9	Healthy Weight
    25.0 – 29.9	Overweight
    30.0 and Above	Obesity
     */

    private fun getWeightStatus(bmi: String): String{
        if(bmi == "NaN" || bmi == "Infinity") {
            return ""
        }
        val bmiFloat = bmi.toFloat()
        return when{
            bmiFloat < 18.5 -> {
                "Underweight"
            }
            bmiFloat < 25 -> {
                "Healthy Weight"
            }
            bmiFloat < 30 -> {
                "Overweight"
            }
            else -> {
                "Obesity"
            }
        }
    }

    private fun sendUiEvent(uiEvent: UiEvents) {
        viewModelScope.launch {
            when (uiEvent) {
                is UiEvents.ShowSnackbar -> uiEvents.send(UiEvents.ShowSnackbar(message = uiEvent.message))
                UiEvents.CalculationSuccessful -> uiEvents.send(UiEvents.CalculationSuccessful)
            }
        }
    }
}

sealed class BmiCalculatorScreenEvents() {
    object AdultRadioButtonClicked : BmiCalculatorScreenEvents()
    object ChildRadioButtonClicked : BmiCalculatorScreenEvents()
    data class HeightTextFieldValueChanged(val newValue: String) : BmiCalculatorScreenEvents()
    data class WeightTextFieldValueChanged(val newValue: String) : BmiCalculatorScreenEvents()
    object CalculateBmiButtonClicked : BmiCalculatorScreenEvents()
}

sealed class UiEvents() {
    data class ShowSnackbar(val message: String) : UiEvents()
    object CalculationSuccessful: UiEvents()
}