package com.example.animalsapp.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Taxonomy(
    val kingdom: String,
    val phylum: String,
    @SerializedName("class")
    val classValue: String,
    val order: String,
    val family: String,
    val genus: String,
    @SerializedName("scientific_name")
    val scientificName: String
): Serializable