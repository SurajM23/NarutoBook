package com.example.narutobook.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.narutobook.ui.components.NetworkImageWithText
import com.example.narutobook.ui.components.Toolbar

@Composable
fun DashboardScreen(modifier: Modifier) {
    Column {
        Toolbar(modifier, "Dashboard")
        DashboardItemList(modifier = modifier)
    }
}

@Composable
fun DashboardItemList(modifier: Modifier) {
    Box(
        modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Column(modifier.padding(8.dp)) {
            Row(modifier = modifier.height(200.dp)) {
                ImageCard(
                    "Characters",
                    "https://static.wikia.nocookie.net/naruto/images/7/7d/Naruto_Part_II.png",
                    modifier = Modifier.weight(1f)
                )
                ImageCard(
                    "Tailed Beasts",
                    "https://static.wikia.nocookie.net/naruto/images/e/e6/Ten-Tails_emerges.png",
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
fun ImageCard(
    title: String,
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        NetworkImageWithText(title, imageUrl, modifier)
    }
}
