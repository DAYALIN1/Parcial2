package com.d00042423.parcial_2.ui.components


import androidx.compose.ui.graphics.vector.ImageVector

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items

data class BottomNavItem(val route: String, val icon: ImageVector, val label: String)

@Composable
fun BottomBar(navController: NavHostController) {


    val items = listOf(
        BottomNavItem("ProductDetailScreen", Icons.Default.List, "producto"),
        BottomNavItem("orders", Icons.Default.ShoppingCart, "Pedidos"),
        BottomNavItem("ProductListScreen", Icons.Default.Search, "listProduct")

    )

    NavigationBar(
        containerColor = Color(0xFFEF4A1D),
        contentColor = Color.White
    ){
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }
                }
            )
        }
    }
}
