package com.npace.kmpdemo

import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.MutableStateFlow
import com.rickclephas.kmm.viewmodel.coroutineScope
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel : KMMViewModel() {
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
            delay(2000)
            _state.update {
                it.copy(
                    loading = false,
                    items = CheeseViewStateFakeData.cheeseViewStates,
                )
            }
        }
    }
}
