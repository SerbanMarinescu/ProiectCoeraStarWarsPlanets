package com.example.coeraproject.data.repository

import com.example.coeraproject.data.local.PlanetEntity
import com.example.coeraproject.data.local.PlanetsDatabase
import com.example.coeraproject.data.mapper.toPlanetEntity
import com.example.coeraproject.data.remote.PlanetsAPI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class PlanetsRepository(
    private val planetsAPI: PlanetsAPI,
    private val planetsDb: PlanetsDatabase
) {

    suspend fun getPlanets(): Flow<List<PlanetEntity>> {

        try {
            val response = planetsAPI.getPlanets()
            val planetsList = response.body()?.results

            val planetEntities = planetsList?.map { it.toPlanetEntity() }

            planetEntities?.let {
                planetsDb.planetsDao.upsertPlanets(it)
            }

            return planetsDb.planetsDao.getAllPlanets()

        } catch (e: HttpException) {
            return flow {  }
        } catch (e: IOException) {
            return flow {  }
        }
    }
}