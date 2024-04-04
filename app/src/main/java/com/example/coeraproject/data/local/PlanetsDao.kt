package com.example.coeraproject.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface PlanetsDao {

    @Upsert
    suspend fun upsertPlanets(planet: List<PlanetEntity>)

    @Query("SELECT * FROM PlanetEntity")
    fun getAllPlanets(): Flow<List<PlanetEntity>>
}