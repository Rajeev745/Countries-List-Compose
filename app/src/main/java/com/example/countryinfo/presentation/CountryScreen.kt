package com.example.countryinfo.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CountryScreen(
    countryState: CountryState,
    onSelectedCountry: (code: String) -> Unit,
    onDismissClick: () -> Unit
) {

    Box(modifier = Modifier.fillMaxSize()) {
        if (countryState.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(countryState.countryList) { country ->
                    CountryCard(simpleCountry = country,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onSelectedCountry(country.code) }
                            .padding(16.dp))
                }
            }

            if (countryState.selectedCountry != null) {
                CountryDialog(
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.White)
                        .padding(16.dp),
                    country = countryState.selectedCountry,
                    onDismiss = onDismissClick
                )
            }
        }
    }
}

@Preview
@Composable
fun CountryScreenPreview() {
    val countryState = CountryState()
    CountryScreen(countryState = countryState, onSelectedCountry = {}, onDismissClick = {})
}