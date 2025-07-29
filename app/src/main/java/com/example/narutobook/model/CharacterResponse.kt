package com.example.narutobook.model

data class CharacterResponse(
    val characters: List<Character>
)

data class Character(
    val id: Int,
    val name: String,
    val images: List<String>,
    val debut: Debut,
    val family: Family,
    val jutsu: List<String>
)

data class Debut(
    val manga: String?,
    val anime: String?,
    val novel: String?,
    val movie: String?,
    val game: String?,
    val ova: String?,
    val appearsIn: String?
)

data class Family(
    val father: String?,
    val mother: String?,
    val son: String?,
    val daughter: String?,
    val wife: String?,
    val godfather: String?
)
