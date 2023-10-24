package com.npace.kmpdemo.api

import kotlinx.serialization.Serializable

@Serializable
data class CheeseResponse(
    val name: String,
    val imagePath: String?,
    val description: String,
)
