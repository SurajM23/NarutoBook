package com.example.narutobook.ui.screens

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.narutobook.model.Character
import com.example.narutobook.viewModel.CharacterViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL


@Composable
fun CharacterScreen(viewModel : CharacterViewModel = viewModel()) {
    val characters by viewModel.characters.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    if (isLoading) {
        CircularProgressIndicator(modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center))
    } else {
        LazyColumn {
            items(characters) { character ->
                CharacterItem(character)
            }
        }
    }
}

@Composable
fun CharacterItem(character: Character) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = character.name, fontWeight = FontWeight.Bold)

        character.images.firstOrNull()?.let { imageUrl ->
            val context = LocalContext.current
            var bitmap by remember { mutableStateOf<Bitmap?>(null) }

            // Load image from URL manually (basic way, not production optimized)
            LaunchedEffect(imageUrl) {
                withContext(Dispatchers.IO) {
                    try {
                        val input = URL(imageUrl).openStream()
                        val bmp = BitmapFactory.decodeStream(input)
                        withContext(Dispatchers.Main) {
                            bitmap = bmp
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }

            bitmap?.let {
                Image(
                    bitmap = it.asImageBitmap(),
                    contentDescription = character.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))
    }
}
