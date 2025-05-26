package com.d00042423.parcial_2.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.d00042423.parcial_2.ViewModel.ProductViewModel
import com.d00042423.parcial_2.ui.components.BottomBar
import com.d00042423.parcial_2.ui.components.ProductCard
import com.d00042423.parcial_2.ui.components.TopBar

@Composable
fun ProductListScreen(
    navController: NavHostController,
    viewModel: ProductViewModel = viewModel()
) {
    val restaurantCategories by viewModel.productByCategory.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFFBF2EB)
    ) {
        Scaffold(
            topBar = { TopBar() },
            bottomBar = { BottomBar(navController) }
        ) { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                restaurantCategories.forEach { (category, products) ->
                    item {
                        Column {
                            Text(
                                text = category,
                                style = MaterialTheme.typography.titleLarge,
                                color = MaterialTheme.colorScheme.primary
                            )

                            LazyRow(
                                horizontalArrangement = Arrangement.spacedBy(16.dp),
                                modifier = Modifier.padding(top = 8.dp)
                            ) {
                                items(products) { product ->
                                    ProductCard(
                                        product = product,
                                        onClick = {
                                            navController.navigate("detalle/${product.id}")
                                        }
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
