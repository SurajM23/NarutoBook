package com.example.narutobook.repository

import com.example.narutobook.api.RetrofitInstance
import com.example.narutobook.model.Character
class CharacterRepository {
    suspend fun fetchCharacters(): List<Character> {
        val response = RetrofitInstance.api.getCharacters()
        return if (response.isSuccessful && response.body() != null) {
            response.body()!!.characters
        } else {
            emptyList()
        }
    }
}
