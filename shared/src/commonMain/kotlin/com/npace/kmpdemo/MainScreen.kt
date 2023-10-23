package com.npace.kmpdemo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

class MainScreen : Screen {
    @Composable
    override fun Content() {
        MyApplicationTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                val viewModel = rememberScreenModel { MainViewModel() }
                val state by viewModel.state.collectAsState()
                CheeseList(state.items)
                if (state.loading) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center,
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }
}

@Composable
private fun CheeseList(items: List<CheeseViewState>) {
    LazyColumn(
        modifier = Modifier.padding(8.dp),
        content = {
            items(
                items = items,
                key = { it.cheeseName },
                itemContent = {
                    CheeseListItem(it)
                }
            )
        }
    )
}

@Composable
private fun CheeseListItem(state: CheeseViewState) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (state.imageUrl != null) {
                KamelImage(
                    asyncPainterResource(state.imageUrl),
                    contentDescription = "Picture of ${state.cheeseName}",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(64.dp)
                        .aspectRatio(1.0f)
                        .clip(RoundedCornerShape(8.dp)),
                )
            }
            Text(state.cheeseName, style = MaterialTheme.typography.titleLarge)
        }
    }
}
