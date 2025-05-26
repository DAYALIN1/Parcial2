package com.d00042423.parcial_2.Navigation


import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.d00042423.parcial_2.ui.screens.ProductDetailScreen
import com.d00042423.parcial_2.ui.screens.ProductListScreen
import com.d00042423.parcial_2.ui.screens.orders


@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "restaurantsList" ) {
        composable ("restaurantsList"){
            ProductListScreen(navController)
        }
        composable("detalle/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id") ?: return@composable
            ProductDetailScreen(navController, id, viewModel())
        }


        composable ("orders"){
            orders(navController)
        }



    }
}