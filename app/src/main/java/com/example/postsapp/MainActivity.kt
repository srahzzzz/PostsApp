package com.example.postsapp.network

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.postsapp.ui.theme.PostsAppTheme
import com.example.postsapp.network.RetrofitClient
import com.example.postsapp.repository.MessageRepository
import com.example.postsapp.viewmodel.MainViewModel
import com.example.postsapp.ui.theme.MainScreen
import com.example.postsapp.data.ApiService

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Manual DI setup
        val api = RetrofitClient.apiService
        val repository = MessageRepository(api)
        val viewModel = MainViewModel(repository)

        setContent {
            PostsAppTheme {
                MainScreen(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PostsAppTheme {
        Greeting("Android")
    }
}