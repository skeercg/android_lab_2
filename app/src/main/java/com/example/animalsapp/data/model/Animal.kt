package com.example.animalsapp.data.model

import java.io.Serializable

data class Animal(
    val name: String,
    val taxonomy: Taxonomy,
    val locations: List<String>,
    val characteristics: Characteristics
): Serializable
