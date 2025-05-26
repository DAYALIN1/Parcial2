package com.d00042423.parcial_2.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.d00042423.parcial_2.ViewModel.ProductViewModel
import com.d00042423.parcial_2.ui.components.TopBar

@Composable

fun ProductDetailScreen(
    navController: NavHostController,
    restaurantId: String,
    viewModel: ProductViewModel
) {
    if (productId == null) {
        Text("ID inválido.")
        return
    }

    val product = viewModel.getProductById(productId)

    product?.let {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = rememberImagePainter(it.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(it.name, style = MaterialTheme.typography.headlineMedium)
            Text("Tipo: ${it.type}")
            Text("Edad: ${it.age} años")
            Spacer(modifier = Modifier.height(8.dp))
            Text(it.description)
        }
    } ?: run {
        Text("producti no encontrado.")
    }
}


val context = LocalContext.current
    val restaurant = viewModel.getProductById(productId)
    var searchText by remember { mutableStateOf(TextFieldValue("")) }

    val filteredDishes = remember(searchText, restaurant) {
        restaurant?.menu?.filter {
            it.name.contains(searchText.text, ignoreCase = true)
        } ?: emptyList()
    }


    Scaffold(
        topBar = {
            TopBar(
                title = restaurant?.name ?: "Detalles",
                showBackButton = true,
                onBackClick = { navController.popBackStack() }
            )


        },
        containerColor = Color(0xFFFBF2EB)
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            product?.let {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                ) {
                    Text(text = it.name, style = MaterialTheme.typography.headlineSmall)
                    Text(text = it.description, style = MaterialTheme.typography.bodyMedium)
                    Text(text = it.price, style = MaterialTheme.typography.headlineSmall)

                    Text(
                        text = "Categorías: ${it.categories.joinToString()}",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }


            OutlinedTextField(
                value = searchText,
                onValueChange = { searchText = it },
                label = { Text("Buscar producto") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(filteredDishes) { dish ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            AsyncImage(
                                model = product.imgURL,
                                contentDescription = product.name,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(180.dp)
                            )
                            Text(product.name, style = MaterialTheme.typography.titleMedium)
                            Text(dish.description, style = MaterialTheme.typography.bodyMedium)

                            Button(
                                onClick = {
                                    Toast.makeText(
                                        context,
                                        "${product.name} agregado al carrito",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                },
                                modifier = Modifier
                                    .align(Alignment.End)
                                    .padding(top = 8.dp)
                            ) {
                                Text("Agregar al carrito")
                            }
                        }
                    }
                }
            }
        }
    }
}
