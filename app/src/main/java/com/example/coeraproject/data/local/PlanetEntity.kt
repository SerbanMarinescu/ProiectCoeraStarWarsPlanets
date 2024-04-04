package com.example.coeraproject.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PlanetEntity(
    val name: String,
    val climate: String,
    val created: String,
    val diameter: String,
    val edited: String,
    val films: Int,
    val gravity: String,
    val orbitalPeriod: String,
    val population: String,
    val residents: Int,
    val rotationPeriod: String,
    val surfaceWater: String,
    val terrain: String,
    val url: String,
    @PrimaryKey
    val id: Int = 0
)
