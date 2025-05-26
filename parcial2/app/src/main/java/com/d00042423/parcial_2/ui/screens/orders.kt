package com.d00042423.parcial_2.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.d00042423.parcial_2.ui.components.BottomBar
import com.d00042423.parcial_2.ui.components.TopBar

@Composable
fun orders(navController: NavHostController){

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFFBF2EB)
    ) {
        Scaffold(
            topBar = { TopBar() },
            bottomBar = { BottomBar(navController) }
        ) { paddingValues ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                color = Color(0xFFFBF2EB)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "no hay ordenes",
                        fontSize = 20.sp,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}
