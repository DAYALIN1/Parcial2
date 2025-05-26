package com.d00042423.parcial_2.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.d00042423.parcial_2.ViewModel.ProductViewModel
import com.d00042423.parcial_2.ui.components.TopBar

@Composable
fun ProductDetailScreen(
    navController: NavHostController,
    productId: String,
    viewModel: ProductViewModel
) {
    val context = LocalContext.current
    val product = viewModel.getProductById(productId.toIntOrNull() ?: -1)

    Scaffold(
        topBar = {
            TopBar(
                title = product?.name ?: "Detalles",
                showBackButton = true,
                onBackClick = { navController.popBackStack() }
            )
        },
        containerColor = Color(0xFFFBF2EB)
    ) { padding ->
        if (product == null) {
            Text("Producto no encontrado", modifier = Modifier.padding(16.dp))
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp)
            ) {
                AsyncImage(
                    model = product.image,
                    contentDescription = product.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(product.name, style = MaterialTheme.typography.headlineMedium)
                Text("Categoría: ${product.category}")
                Text("Precio: $${product.price}")
                Spacer(modifier = Modifier.height(8.dp))
                Text(product.description)

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
