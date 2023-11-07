package com.sylv42240.fizz_buzz.shared.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.sylv42240.fizz_buzz.screen.form.FormScreen
import com.sylv42240.fizz_buzz.screen.list.FizzBuzzListScreen

@Composable
fun FizzBuzzNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = FormScreen.getRoute()
    ) {
        FormScreen.buildScreen(this, navController)
        FizzBuzzListScreen.buildScreen(this, navController)
    }
}
