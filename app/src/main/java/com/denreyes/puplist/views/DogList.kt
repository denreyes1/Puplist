package com.denreyes.puplist.views

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
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.denreyes.puplist.DogsViewModel
import com.denreyes.puplist.data.Dog
import com.denreyes.puplist.ui.theme.PuplistTheme

@Composable
fun DogList(modifier: Modifier) {
    val dogsViewModel = DogsViewModel()
    Column(
        modifier = modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn {
            items(dogsViewModel.getDogs()) { dog ->
                DogListItem(dog = dog)
            }
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
                model = dog.image,
                contentDescription = "Dog",
                modifier = Modifier
                    .fillMaxSize()
                    .height(200.dp),
                contentScale = ContentScale.FillWidth
            )
//            FlowRow(
//                modifier = Modifier
//                    .padding(start = 6.dp, end = 6.dp)
//            ) {
//                repeat()
//            }
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