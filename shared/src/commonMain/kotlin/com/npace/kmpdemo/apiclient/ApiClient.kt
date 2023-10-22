package com.npace.kmpdemo.apiclient

import com.npace.kmpdemo.api.CheeseResponse

interface ApiClient {
    suspend fun loadItems(): List<CheeseResponse>
}
