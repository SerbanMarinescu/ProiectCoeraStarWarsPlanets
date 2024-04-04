package com.example.coeraproject.data.remote.dto

data class PlanetsDto(
    val count: Int,
    val next: String,
    val previous: String?,
    val results: List<PlanetResponse>
)
