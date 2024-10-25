package com.denreyes.puplist.views

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.denreyes.puplist.DogsViewModel
import com.denreyes.puplist.data.Dog
import com.denreyes.puplist.ui.theme.PuplistTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun DogList(modifier: Modifier) {
    val dogsViewModel: DogsViewModel = koinViewModel()
    val dogsUIState by dogsViewModel.dogsUIState.collectAsStateWithLifecycle()
    Column(
        modifier = modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedVisibility(
            visible = dogsUIState.isLoading
        ) {
            CircularProgressIndicator()
        }
        AnimatedVisibility (
            visible = dogsUIState.dogs.isNotEmpty()
        ) {
            LazyColumn {
                items(dogsUIState.dogs) { dog ->
                    DogListItem(dog = dog)
                }
            }
        }
        AnimatedVisibility(
            visible = dogsUIState.error != null
        ) {
            Text(text = dogsUIState.error ?: "")
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DogListItem(dog: Dog) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxSize()
            .padding(6.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 10.dp)
        ) {
            AsyncImage(
                model = dog.url,
                contentDescription = "Dog",
                modifier = Modifier
                    .fillMaxSize()
                    .height(200.dp),
                contentScale = ContentScale.FillWidth
            )
            FlowRow(
                modifier = Modifier
                    .padding(start = 6.dp, end = 6.dp)
            ) {
                if (dog.breeds?.isNotEmpty()!!) {
                    val temperaments = dog.breeds[0].temperament.split(", ")
                    for (temperament in temperaments) {
                        SuggestionChip(
                            modifier = Modifier
                                .padding(start = 3.dp, end = 3.dp),
                            onClick = { },
                            label = {
                                Text(text = temperament)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DogListPreview() {
    PuplistTheme {
        DogList(modifier = Modifier)
    }
}