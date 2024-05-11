package com.example.countryinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.countryinfo.presentation.CountryScreen
import com.example.countryinfo.presentation.CountryViewModel
import com.example.countryinfo.ui.theme.CountryInfoTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountryInfoTheme {
                val viewModel = hiltViewModel<CountryViewModel>()
                val countryState = viewModel.countryState.collectAsState()
                CountryScreen(
                    countryState = countryState.value,
                    onSelectedCountry = viewModel::getSelectedCountry,
                    onDismissClick = viewModel::dismissCountryDialog
                )
            }
        }
    }
}