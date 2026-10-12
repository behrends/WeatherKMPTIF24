package com.example.weatherkmptif24.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherkmptif24.data.fakeCities
import com.example.weatherkmptif24.model.City
import com.example.weatherkmptif24.ui.theme.WeatherAndroidTIF24Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityListScreen(
    cities: List<City>,
    onCityClick: (City) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = { TopAppBar(title = { Text(text = "Städte") }) },
    ) { innerPadding ->
        LazyColumn(contentPadding = innerPadding) {
            items(cities, key = { it.name }) { city ->
                ListItem(
                    headlineContent = { Text(text = city.name) },
                    supportingContent = {
                        Text(text = "%.2f° N, %.2f° O".format(city.latitude, city.longitude))
                    },
                    modifier = Modifier.clickable { onCityClick(city) },
                )
                HorizontalDivider()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CityListScreenPreview() {
    WeatherAndroidTIF24Theme {
        CityListScreen(cities = fakeCities, onCityClick = {})
    }
}
