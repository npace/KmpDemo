package com.npace.kmpdemo

data class CheeseViewState(
    val cheeseName: String,
)

object CheeseViewStateFakeData {
    val cheeseViewStates = listOf(
        CheeseViewState("Brie"),
        CheeseViewState("Cheddar"),
        CheeseViewState("Feta"),
        CheeseViewState("Gouda"),
        CheeseViewState("Gorgonzola"),
        CheeseViewState("Mozzarella"),
        CheeseViewState("Havarti"),
        CheeseViewState("Kashkaval"),
        CheeseViewState("Sirene"),
    )
}
