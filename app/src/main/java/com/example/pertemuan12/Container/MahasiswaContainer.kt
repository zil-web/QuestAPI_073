package com.example.pertemuan12.Container

import com.example.pertemuan12.repository.MahasiswaRepository
import com.example.pertemuan12.repository.MahasiswaRepositry
import com.example.pertemuan12.service.MahasiswaService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val kontakRepository:
            MahasiswaRepository
}
