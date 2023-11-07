package com.sylv42240.fizz_buzz.screen.form.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sylv42240.fizz_buzz.R
import com.sylv42240.fizz_buzz.shared.theme.FizzBuzzTheme

@Composable
fun FormSubmitButton(enabled: Boolean, onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        onClick = onClick,
        enabled = enabled
    ) {
        Text(
            text = stringResource(id = R.string.submit_button_text),
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Preview
@Composable
private fun FormSubmitButton_Preview() {
    FizzBuzzTheme {
        FormSubmitButton(enabled = true, onClick = {})
    }
}