package com.npace.kmpdemo.apiclient

import com.npace.kmpdemo.api.CheeseResponse
import com.npace.kmpdemo.getPlatform
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json

class KtorApiClient : ApiClient {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }

    override suspend fun loadItems(): List<CheeseResponse> {
        return client.get(getPlatform().localServerHost).body()
    }
}
