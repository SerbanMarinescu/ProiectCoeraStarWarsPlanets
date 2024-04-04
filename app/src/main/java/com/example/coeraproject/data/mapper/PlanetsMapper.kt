package com.example.coeraproject.data.mapper

import com.example.coeraproject.data.local.PlanetEntity
import com.example.coeraproject.data.remote.dto.PlanetResponse
import com.example.coeraproject.data.remote.dto.PlanetsDto

fun PlanetResponse.toPlanetEntity(): PlanetEntity {
    return PlanetEntity(
        name = name,
        climate = climate,
        created = created,
        diameter = diameter,
        edited = edited,
        films = films.size,
        gravity = gravity,
        orbitalPeriod = orbital_period,
        population = population,
        residents = residents.size,
        rotationPeriod = rotation_period,
        surfaceWater = surface_water,
        terrain = terrain,
        url = url
    )
}