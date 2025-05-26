package com.d00042423.parcial_2.DummyData

import com.d00042423.parcial_2.Model.Product

fun ObtenerProduct(): List<Product> {
    return listOf(
        Product(
            id = 1,
            name = "Computadora",
            category = "Tecnologia",
            price = 22.33,
            description = "Computadora de última generación",
            image = "https://th.bing.com/th/id/OIP.UxHQMTi7GOuKGJul1sQJTgHaEh?cb=iwc2&rs=1&pid=ImgDetMain"
        )
    )
}
