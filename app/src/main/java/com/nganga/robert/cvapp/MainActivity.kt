package com.nganga.robert.cvapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nganga.robert.cvapp.ui.theme.CVAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = viewModel<DetailsViewModel>()
            val navController = rememberNavController()
            CVAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFF0F2F3)
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = "homeScreen"
                    ){
                        composable(route = "homeScreen"){
                            HomeScreen(
                                onEditClick = {
                                      navController.navigate(route = "editScreen")
                                },
                                detailsViewModel = viewModel
                            )
                        }
                        composable(route = "editScreen"){
                            EditScreen(
                                detailsViewModel = viewModel,
                                onBackPressed = {
                                    navController.popBackStack()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CVAppTheme {
    }
}