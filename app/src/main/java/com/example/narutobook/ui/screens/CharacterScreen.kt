package com.example.narutobook.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.narutobook.ui.components.CharacterItem
import com.example.narutobook.ui.components.Toolbar
import com.example.narutobook.viewModel.CharacterViewModel


@Composable
fun CharacterScreen(viewModel: CharacterViewModel = viewModel()) {
    val characters by viewModel.characters.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    var modifier = Modifier
    Column {

        Toolbar(modifier, "Characters...")

        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
        } else {
            LazyColumn {
                items(characters) { character ->
                    CharacterItem(modifier, character)
                }
            }
        }
    }
}


