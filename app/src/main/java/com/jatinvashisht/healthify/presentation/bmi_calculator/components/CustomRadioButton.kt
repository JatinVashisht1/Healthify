package com.jatinvashisht.healthify.presentation.bmi_calculator.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import com.jatinvashisht.healthify.presentation.util.MyPaddings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomRadioButtonRow(
    modifier: Modifier = Modifier,
    isAdult: Boolean,
    onAdultRadioButtonClicked: () -> Unit,
    onChildRadioButtonClicked: () -> Unit
) {

    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = isAdult, onClick = onAdultRadioButtonClicked)
        Text(text = "Adult (18+)", modifier = Modifier.clickable(onClick = onAdultRadioButtonClicked, role = Role.RadioButton), color = MaterialTheme.colorScheme.onSurface)

        Spacer(modifier = Modifier.width(MyPaddings.Small.padding))

        RadioButton(selected = !isAdult, onClick = onChildRadioButtonClicked)
        Text(text = "Child (<18)", modifier = Modifier.clickable(onClick = onChildRadioButtonClicked, role = Role.RadioButton), color = MaterialTheme.colorScheme.onSurface)

    }
}