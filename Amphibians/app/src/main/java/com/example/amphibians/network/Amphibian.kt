package com.example.amphibians.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//Clase de datos que define un anfibio e incluye un nombre, tipo, descripción y URL de la imagen.
@Serializable
data class Amphibian(
val name: String,
val type: String,
val description: String,
@SerialName(value = "img_src")
val imgSrc: String
)
