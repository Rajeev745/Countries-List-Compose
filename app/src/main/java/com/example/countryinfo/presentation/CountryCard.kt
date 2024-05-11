package com.example.countryinfo.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.countryinfo.domain.model.SimpleCountry

@Composable
fun CountryCard(modifier: Modifier = Modifier, simpleCountry: SimpleCountry) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(text = simpleCountry.emoji, fontSize = 30.sp)

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(text = simpleCountry.name, fontSize = 24.sp)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = simpleCountry.capital)
        }
    }
}

@Preview
@Composable
fun CountryCardPreview() {
    CountryCard(
        Modifier, SimpleCountry(
            name = "India",
            emoji = "Rah",
            capital = "Delhi",
            currency = "Rs",
            code = "In"
        )
    )
}