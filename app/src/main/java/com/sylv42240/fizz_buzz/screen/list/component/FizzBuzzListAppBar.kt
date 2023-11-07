package com.sylv42240.fizz_buzz.screen.list.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sylv42240.fizz_buzz.R
import com.sylv42240.fizz_buzz.shared.theme.FizzBuzzTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FizzBuzzListAppBar(navController: NavController) {
    TopAppBar(
        title = {
            Text(text = stringResource(R.string.app_name))
        },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = null
                )
            }
        },
        modifier = Modifier.shadow(elevation = 8.dp)
    )
}

@Preview
@Composable
private fun FizzBuzzListAppBar_Preview() {
    FizzBuzzTheme {
        FizzBuzzListAppBar(navController = rememberNavController())
    }
}