package com.nganga.robert.cvapp.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsFormField(
    value: String,
    modifier: Modifier = Modifier,
    label: String = "",
    onValueChanged: (String)->Unit
){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        modifier = modifier
            .fillMaxWidth(),
        label = {
            Text(text = label)
        },
        shape = RoundedCornerShape(8.dp)
    )
}