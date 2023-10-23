package com.npace.kmpdemo

import com.npace.kmpdemo.apiclient.ApiClient
import com.npace.kmpdemo.apiclient.KtorApiClient
import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.MutableStateFlow
import com.rickclephas.kmm.viewmodel.coroutineScope
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val apiClient: ApiClient,
    private val platform: Platform,
) : KMMViewModel() {

    constructor() : this(KtorApiClient(), getPlatform())

    data class MainUIState(
        val loading: Boolean,
        val items: List<CheeseViewState>,
    )

    private val _state = MutableStateFlow(
        viewModelScope, MainUIState(
            loading = true,
            items = emptyList(),
        )
    )

    @NativeCoroutinesState
    val state = _state.asStateFlow()

    init {
        viewModelScope.coroutineScope.launch {
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
