package com.denreyes.puplist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.denreyes.puplist.ui.theme.PuplistTheme
import com.denreyes.puplist.views.DogList

val API_KEY = "live_rxR1supp7CKDMaiCRIPTJHqWumeVwEJ3Z5sdGqicYWtt3ioRUwVtXsGiXATaxQAs"

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PuplistTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(title = {
                            Text(text = "Puplist")
                        },
                            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
                        )
                    },
                    content = { paddingValues ->
                        ListDogs(pad = paddingValues)
                    }
                )
            }
        }
    }
}

@Composable
fun ListDogs(pad: PaddingValues) {
    DogList(
        modifier = Modifier
            .fillMaxSize()
            .padding(pad)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PuplistTheme {
        ListDogs(PaddingValues())
    }
}