package com.example.animalsapp.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Characteristics(
    val prey: String,
    @SerializedName("name_of_young")
    val nameOfYoung: String,
    @SerializedName("group_behavior")
    val groupBehavior: String,
    @SerializedName("estimated_population_size")
    val estimatedPopulationSize: String,
    @SerializedName("biggest_threat")
    val biggestThreat: String,
    @SerializedName("most_distinctive_feature")
    val mostDistinctiveFeature: String,
    @SerializedName("gestation_period")
    val gestationPeriod: String,
    val habitat: String,
    val diet: String,
    @SerializedName("average_litter_size")
    val averageLitterSize: String,
    val lifestyle: String,
    @SerializedName("common_name")
    val commonName: String,
    @SerializedName("number_of_species")
    val numberOfSpecies: String,
    val location: String,
    val slogan: String,
    val group: String,
    val color: String,
    @SerializedName("skin_type")
    val skinType: String,
    @SerializedName("top_speed")
    val topSpeed: String,
    val lifespan: String,
    val weight: String,
    val height: String,
    @SerializedName("age_of_sexual_maturity")
    val ageOfSexualMaturity: String,
    @SerializedName("age_of_weaning")
    val ageOfWeaning: String
): Serializable