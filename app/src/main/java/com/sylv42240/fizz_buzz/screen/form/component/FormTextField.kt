package com.sylv42240.fizz_buzz.screen.form.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sylv42240.fizz_buzz.shared.theme.FizzBuzzTheme

@Composable
fun FormTextField(
    label: String,
    value: String,
    isLast: Boolean = false,
    focusManager: FocusManager,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = value,
        onValueChange = {
            if (it.length < 10){
                onValueChange(it)
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 2.dp, shape = MaterialTheme.shapes.medium),
        shape = MaterialTheme.shapes.medium,
        trailingIcon = {
            IconButton(onClick = { onValueChange("") }) {
                Icon(Icons.Filled.Clear, contentDescription = null)
            }
        },
        label = {
            Text(text = label)
        },
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = if (isLast) ImeAction.Done else ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = { focusManager.moveFocus(FocusDirection.Next) },
            onDone = { focusManager.clearFocus() }
        )
    )
}

@Preview
@Composable
fun FormTextField_Preview() {
    FizzBuzzTheme {
        FormTextField(
            label = "First word",
            value = "Example",
            focusManager = LocalFocusManager.current,
            onValueChange = {})
    }
}