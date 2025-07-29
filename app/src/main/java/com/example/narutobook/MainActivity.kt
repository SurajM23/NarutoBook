package com.example.narutobook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.narutobook.repository.CharacterRepository
import com.example.narutobook.ui.screens.CharacterScreen
import com.example.narutobook.ui.theme.NarutoBookTheme
import com.example.narutobook.viewModel.CharacterViewModel
import com.example.narutobook.viewModel.CharacterViewModelFactory

class MainActivity : ComponentActivity() {

    private val characterViewModel: CharacterViewModel by viewModels {
        CharacterViewModelFactory(CharacterRepository())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NarutoBookTheme {
                CharacterScreen(characterViewModel)
            }
        }
    }
}
