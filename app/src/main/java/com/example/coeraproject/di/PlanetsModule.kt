package com.example.coeraproject.di

import android.content.Context
import androidx.room.Room
import com.example.coeraproject.common.Constants
import com.example.coeraproject.common.Constants.BASE_URL
import com.example.coeraproject.common.Constants.DATABASE_NAME
import com.example.coeraproject.data.local.PlanetsDatabase
import com.example.coeraproject.data.remote.PlanetsAPI
import com.example.coeraproject.data.repository.PlanetsRepository
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object PlanetsModule {



    @Singleton
    @Provides
    fun providePlanetsApi(
        moshi: Moshi
    ): PlanetsAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create()
    }

    @Singleton
    @Provides
    fun providePlanetsDatabase(
        @ApplicationContext context: Context
    ): PlanetsDatabase {
        return Room.databaseBuilder(
            context,
            PlanetsDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideRepository(
        api: PlanetsAPI,
        db: PlanetsDatabase
    ): PlanetsRepository {
        return PlanetsRepository(api, db)
    }
}