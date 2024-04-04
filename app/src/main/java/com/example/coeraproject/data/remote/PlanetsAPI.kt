package com.example.coeraproject.data.remote

import com.example.coeraproject.data.remote.dto.PlanetsDto
import retrofit2.Response
import retrofit2.http.GET

interface PlanetsAPI {

    @GET("planets/")
    suspend fun getPlanets(): Response<PlanetsDto>
}