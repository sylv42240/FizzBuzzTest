package com.sylv42240.fizz_buzz.screen.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sylv42240.fizz_buzz.R
import com.sylv42240.fizz_buzz.screen.list.component.FizzBuzzListAppBar
import com.sylv42240.fizz_buzz.screen.list.component.FizzBuzzListLazyColumn
import com.sylv42240.fizz_buzz.shared.base.BaseScreen
import kotlinx.coroutines.launch

object FizzBuzzListScreen : BaseScreen {
    override fun getRoute() = "list"

    override fun buildScreen(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(route = getRoute()) {
            Content(viewModel = hiltViewModel(), navController = navController)
        }
    }

    @Composable
    private fun Content(viewModel: FizzBuzzListViewModel, navController: NavController) {
        val context = LocalContext.current
        val scope = rememberCoroutineScope()
        val snackbarHostState = remember { SnackbarHostState() }

        val fizzBuzzList by viewModel.fizzBuzzList.collectAsState()

        LaunchedEffect(key1 = Unit) {
            viewModel.retrieveFizzBuzzList(
                onError = {
                    scope.launch {
                        when (snackbarHostState.showSnackbar(message = context.getString(R.string.general_error))) {
                            SnackbarResult.Dismissed -> navController.popBackStack()
                            else -> {}
                        }

                    }
                }
            )
        }

        Scaffold(
            topBar = {
                FizzBuzzListAppBar(navController = navController)
            },
            content = {
                FizzBuzzListLazyColumn(modifier = Modifier.padding(it), list = fizzBuzzList)
            },
            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState)
            }
        )
    }
}