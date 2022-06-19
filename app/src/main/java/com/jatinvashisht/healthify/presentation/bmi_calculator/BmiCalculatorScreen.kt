package com.jatinvashisht.healthify.presentation.bmi_calculator

import android.app.Activity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.jatinvashisht.healthify.presentation.bmi_calculator.components.CustomRadioButtonRow
import com.jatinvashisht.healthify.presentation.util.MyPaddings
import com.jatinvashisht.healthify.presentation.util.MyPaddings.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun BmiCalculator(
    navController: NavController,
    bmiCalculatorViewModel: BmiCalculatorViewModel = hiltViewModel()
) {

    val lazyListState = rememberLazyListState()
    val bmiCalculatorScreenState = bmiCalculatorViewModel.bmiCalculatorScreen.value
    val snackbarHostState = remember { SnackbarHostState() }
    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(key1 = Unit) {
        bmiCalculatorViewModel.uiEvents.receiveAsFlow().collectLatest { event ->
            when (event) {
                is UiEvents.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(message = event.message)
                }
                UiEvents.CalculationSuccessful -> keyboardController?.hide()
            }
        }
    }

    Scaffold(snackbarHost = { SnackbarHost(hostState = snackbarHostState) }) { padding ->
        LazyColumn(state = lazyListState, modifier = Modifier
            .fillMaxSize()
            .drawBehind {
                drawRect(
                    brush = Brush.verticalGradient(
                        listOf<Color>(
//                            Color(100, 181, 246, 255),
//                            Color(121, 134, 203, 255),
//                            Color(0, 188, 212, 255),
                            Color(1, 87, 155, 255),
                            Color(13, 71, 161, 255),
                        )
                    )
                )
            }) {
            item {
                SmallTopAppBar(
                    title = { Text(text = "BMI Calculator") },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "move back"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = Color(
                            1,
                            87,
                            155,
                            255
                        )
                    )
                )

                CustomRadioButtonRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(Medium.padding),
                    isAdult = bmiCalculatorScreenState.isAdult,
                    onAdultRadioButtonClicked = {
                        bmiCalculatorViewModel.onScreenEventFired(
                            BmiCalculatorScreenEvents.AdultRadioButtonClicked
                        )
                    },
                    onChildRadioButtonClicked = {
                        bmiCalculatorViewModel.onScreenEventFired(
                            BmiCalculatorScreenEvents.ChildRadioButtonClicked
                        )
                    }
                )

//                Spacer(modifier = Modifier.height(Small.padding))
                CustomTextField(
                    value = bmiCalculatorScreenState.height, onValueChanged = { newValue ->
                        bmiCalculatorViewModel.onScreenEventFired(
                            BmiCalculatorScreenEvents.HeightTextFieldValueChanged(newValue = newValue.trim())
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = Medium.padding),
                    label = "height (meter)",
                    placeholder = "enter height (meter)"
                )

                Spacer(modifier = Modifier.height(Medium.padding))
                CustomTextField(
                    value = bmiCalculatorScreenState.weight,
                    placeholder = "enter weight (Kg)",
                    label = "weight (Kg)",
                    onValueChanged = { newValue ->
                        bmiCalculatorViewModel.onScreenEventFired(
                            BmiCalculatorScreenEvents.WeightTextFieldValueChanged(
                                newValue = newValue.trim()
                            )
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = Medium.padding),
                    onDone = {
                        bmiCalculatorViewModel.onScreenEventFired(BmiCalculatorScreenEvents.CalculateBmiButtonClicked)
                    }
                )

                Spacer(modifier = Modifier.height(MyPaddings.Medium.padding))
                Button(
                    onClick = { bmiCalculatorViewModel.onScreenEventFired(BmiCalculatorScreenEvents.CalculateBmiButtonClicked) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = Medium.padding),
                    shape = RoundedCornerShape(4.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(255, 241, 118, 255),
                        contentColor = Color(57, 73, 171, 255),
                    ),
                ) {
                    Text(text = "Calculate BMI")
                }

                Spacer(modifier = Modifier.height(Medium.padding))
                AnimatedVisibility(visible = bmiCalculatorScreenState.result.isNotBlank()) {
                    Text(
                        text = "BMI: ${bmiCalculatorScreenState.result}",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = Medium.padding),
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.headlineSmall
                    )

                }

                AnimatedVisibility(visible = bmiCalculatorScreenState.weightStatus.isNotBlank()) {
                    Spacer(modifier = Modifier.height(Medium.padding))
                    Text(
                        text = "Weight Status: ${bmiCalculatorScreenState.weightStatus}",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = Medium.padding),
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            }
        }
    }
}

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    value: String,
    placeholder: String,
    label: String,
    onValueChanged: (String) -> Unit,
    onDone: KeyboardActionScope.() -> Unit = {}
) {
    OutlinedTextField(
        maxLines = 1,
        modifier = modifier,
        value = value,
        onValueChange = onValueChanged,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Decimal,
            imeAction = if (label == "weight (Kg)") ImeAction.Done else ImeAction.None
        ),
        keyboardActions = KeyboardActions(onDone = onDone),
        label = { Text(text = label, color = MaterialTheme.colorScheme.onSurface) },
        placeholder = { Text(text = placeholder, color = MaterialTheme.colorScheme.onSurface) },

        )
}
