package com.sylv42240.fizz_buzz.screen.form.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sylv42240.fizz_buzz.R
import com.sylv42240.fizz_buzz.shared.theme.FizzBuzzTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormAppBar() {
    TopAppBar(
        title = {
            Text(text = stringResource(R.string.app_name))
        },
        modifier = Modifier.shadow(elevation = 8.dp)
    )
}

@Preview
@Composable
private fun FormAppBar_Preview(){
    FizzBuzzTheme {
        FormAppBar()
    }
}