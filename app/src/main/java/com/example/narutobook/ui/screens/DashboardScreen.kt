package com.example.narutobook.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
    val scrollState = rememberScrollState()
    Box(
        modifier
            .fillMaxSize()
            .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
    ) {
        Column(
            modifier
                .padding(start = 8.dp, end = 8.dp)
                .verticalScroll(scrollState)
        ) {
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
            Row(modifier = modifier.height(200.dp)) {
                ImageCard(
                    "Akatsuki",
                    "",
                    modifier = Modifier.weight(1f)
                )
                ImageCard(
                    "Teams",
                    "https://static.wikia.nocookie.net/naruto/images/7/7d/Konoha_Anbu.png/revision/latest?cb=20150226122737",
                    modifier = Modifier.weight(1f)
                )
            }
            Row(modifier = modifier.height(200.dp)) {
                ImageCard(
                    "Clans",
                    "https://static.wikia.nocookie.net/naruto/images/c/c3/Uchiha_Symbol.svg/revision/latest?cb=20150323000713",
                    modifier = Modifier.weight(1f)
                )
                ImageCard(
                    "Villages",
                    "",
                    modifier = Modifier.weight(1f)
                )
            }
            Row(modifier = modifier.height(200.dp)) {
                ImageCard(
                    "Kekkei Genkai",
                    "",
                    modifier = Modifier.weight(1f)
                )
                ImageCard(
                    "kara",
                    "",
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
