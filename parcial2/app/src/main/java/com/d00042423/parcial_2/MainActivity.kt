package com.d00042423.parcial_2

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
import com.d00042423.parcial_2.Navigation.AppNavigation
import com.d00042423.parcial_2.ui.theme.Parcial_2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Parcial_2Theme {
                AppNavigation()

            }
        }
    }
}

/*                val navController = rememberNavController()
                val petViewModel: PetViewModel = viewModel()
                AppNavGraph(navController, petViewModel)*/

