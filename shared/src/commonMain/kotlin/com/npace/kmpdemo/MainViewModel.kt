package com.npace.kmpdemo

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import com.npace.kmpdemo.apiclient.ApiClient
import com.npace.kmpdemo.apiclient.KtorApiClient
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val apiClient: ApiClient,
    private val platform: Platform,
) : ScreenModel {

    constructor() : this(KtorApiClient(), getPlatform())

    data class MainUIState(
        val loading: Boolean,
        val items: List<CheeseViewState>,
    )

    private val _state = kotlinx.coroutines.flow.MutableStateFlow(
        MainUIState(
            loading = true,
            items = emptyList(),
        )
    )

    @NativeCoroutinesState
    val state = _state.asStateFlow()

    init {
        coroutineScope.launch {
            val response = apiClient.loadItems()
            _state.update {
                it.copy(
                    loading = false,
                    items = response.map { response ->
                        CheeseViewState(
                            response.name,
                            imageUrl(response.imagePath),
                        )
                    },
                )
            }
        }
    }

    private fun imageUrl(path: String?): String? {
        return if (path != null) platform.localServerHost + path else null
    }
}
