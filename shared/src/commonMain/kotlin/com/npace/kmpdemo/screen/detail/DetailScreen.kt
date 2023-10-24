package com.npace.kmpdemo.screen.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.npace.kmpdemo.CheeseViewState
import com.npace.kmpdemo.MyApplicationTheme
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

class DetailScreen(private val state: CheeseViewState) : Screen {

    @Composable
    override fun Content() {
        DetailScaffold {
            DetailContent(state)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScaffold(
    content: @Composable () -> Unit,
) {
    val navigator = LocalNavigator.currentOrThrow
    MyApplicationTheme {
        Scaffold(topBar = {
            TopAppBar(
                title = { Text("Cheese details") },
                navigationIcon = {
                    IconButton(onClick = { navigator.pop() }) {
                        Image(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                        )
                    }
                }
            )
        }) { content() }
    }
}


@Composable
private fun DetailContent(state: CheeseViewState) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Top
    ) {

        val url = state.imageUrl
        if (url != null) {
            KamelImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.0f),
                resource = asyncPainterResource(url),
                contentDescription = "Image of ${state.cheeseName}",
                contentScale = ContentScale.Crop,
            )
        }
        Text(
            text = state.cheeseName,
            style = MaterialTheme.typography.displayMedium
        )
        Text(state.description)
    }
}
