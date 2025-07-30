package com.example.narutobook.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
            .padding(start = 2.dp, end = 2.dp)
    ) {
        Column(
            modifier
                .verticalScroll(scrollState)
        ) {
            ImageCard(
                "Characters",
                "https://preview.redd.it/b0y1hejd2gs71.jpg?width=640&crop=smart&auto=webp&s=2bcb82f52c67245f3ace7d63bd0c79aaccca1a2c",
            )

            Row(modifier = modifier.height(180.dp)) {

                Spacer(modifier = Modifier.width(12.dp))
                ImageCard(
                    "Akatsuki",
                    "https://static.wikia.nocookie.net/naruto-fandom/images/f/f4/Yahiko%27s_Group.PNG/revision/latest?cb=20130626020509",
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(8.dp))
                ImageCard(
                    "Teams",
                    "https://static.wikia.nocookie.net/naruto/images/7/7d/Konoha_Anbu.png/revision/latest?cb=20150226122737",
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(12.dp))
            }

            Row(modifier = modifier.height(180.dp)) {
                Spacer(modifier = Modifier.width(12.dp))
                ImageCard(
                    "Clans",
                    "https://comicbook.com/wp-content/uploads/sites/4/2025/06/Naruto-Founding-of-Konoha.jpg?w=1024",
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(8.dp))
                ImageCard(
                    "Villages",
                    "https://preview.redd.it/which-is-the-strongest-village-other-than-konoha-v0-x3l43ivina7f1.jpeg?width=640&crop=smart&auto=webp&s=631a63796ef3aadd99a0cb66d68f200581e6837e",
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(12.dp))
            }
            Row(modifier = modifier.height(180.dp)) {
                Spacer(modifier = Modifier.width(12.dp))
                ImageCard(
                    "Kekkei Genkai",
                    "https://i.pinimg.com/736x/b8/14/38/b81438d7dafd2c1daa2a8fc2ed404f5b.jpg",
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(8.dp))
                ImageCard(
                    "kara",
                    "https://i.pinimg.com/736x/87/57/9b/87579ba0324f1f8c74d6646225383a31.jpg",
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(12.dp))
            }
            ImageCard(
                "Tailed Beasts",
                "https://wallpapers4screen.com/Uploads/6-4-2025/72073/thumb2-naruto-uzumaki-kurama-4k-naruto-anime-characters.jpg",
            )
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
            .padding(4.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(48.dp)
    ) {
        NetworkImageWithText(title, imageUrl, modifier)
    }
}
