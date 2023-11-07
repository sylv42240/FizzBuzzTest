package com.sylv42240.fizz_buzz.shared.base

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

interface BaseScreen {
    fun getRoute(): String
    fun buildScreen(navGraphBuilder: NavGraphBuilder, navController: NavController)
}