package com.sylv42240.fizz_buzz.screen.form

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sylv42240.fizz_buzz.R
import com.sylv42240.fizz_buzz.screen.form.component.FormAppBar
import com.sylv42240.fizz_buzz.screen.form.component.FormCard
import com.sylv42240.fizz_buzz.screen.form.component.FormHeaderCard
import com.sylv42240.fizz_buzz.screen.form.component.FormNumberTextField
import com.sylv42240.fizz_buzz.screen.form.component.FormSubmitButton
import com.sylv42240.fizz_buzz.screen.form.component.FormTextField
import com.sylv42240.fizz_buzz.shared.base.BaseScreen

object FormScreen : BaseScreen {
    override fun getRoute() = "form"

    override fun buildScreen(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(route = getRoute()) {
            Content(viewModel = hiltViewModel(), navController = navController)
        }
    }

    @Composable
    private fun Content(viewModel: FormViewModel, navController: NavController) {
        val focusManager = LocalFocusManager.current

        val firstWordInput by viewModel.firstWordInput.collectAsState()
        val secondWordInput by viewModel.secondWordInput.collectAsState()
        val firstNumberInput by viewModel.firstNumberInput.collectAsState()
        val secondNumberInput by viewModel.secondNumberInput.collectAsState()
        val showHeaderCard by viewModel.showHeaderCard.collectAsState()
        val isButtonEnabled by viewModel.isButtonEnabled.collectAsState(initial = false)

        Scaffold(
            topBar = {
                FormAppBar()
            },
            content = {
                Column(
                    modifier = Modifier
                        .padding(it)
                        .fillMaxSize()
                        .padding(all = 24.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    FormHeaderCard(
                        isVisible = showHeaderCard,
                        onDismiss = { viewModel.hideHeaderCard() }
                    )

                    Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
                        FormCard {
                            FormNumberTextField(
                                label = stringResource(id = R.string.text_field_first_number_label),
                                value = firstNumberInput,
                                focusManager = focusManager,
                                onValueChange = { input ->
                                    viewModel.onFirstNumberInputValueChanged(input)
                                })
                            FormTextField(
                                label = stringResource(id = R.string.text_field_first_word_label),
                                value = firstWordInput,
                                focusManager = focusManager,
                                onValueChange = { input ->
                                    viewModel.onFirstWordInputValueChanged(input)
                                })
                        }

                        FormCard {
                            FormNumberTextField(
                                label = stringResource(id = R.string.text_field_second_number_label),
                                value = secondNumberInput,
                                focusManager = focusManager,
                                onValueChange = { input ->
                                    viewModel.onSecondNumberInputValueChanged(input)
                                })
                            FormTextField(
                                label = stringResource(id = R.string.text_field_second_word_label),
                                value = secondWordInput,
                                isLast = true,
                                focusManager = focusManager,
                                onValueChange = { input ->
                                    viewModel.onSecondWordInputValueChanged(input)
                                })
                        }
                    }

                    FormSubmitButton(
                        enabled = isButtonEnabled,
                        onClick = { viewModel.submitForm(navController = navController) }
                    )
                }

            }
        )
    }
}