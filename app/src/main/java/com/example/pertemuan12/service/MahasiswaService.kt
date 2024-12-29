package com.example.pertemuan12.service

import com.example.pertemuan12.data.entity.Mahasiswa
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface MahasiswaService {
    @Headers(
        "Accept: appplication/json",
        "Content-Type: application/json",
    )
    @GET("bacaMahasiswa.php")
    suspend fun getKontak(): List<Mahasiswa>

    @GET("baca1Mahasiswa.php/{nim}")
    suspend fun getKontakById(@Query("nim") nim:String) : Mahasiswa

    @POST("insertmahasiswa.php")
    suspend fun insertKontak(@Body mahasiswa: Mahasiswa)

    @PUT("editmahasiswa.php/{nim}")
    suspend fun updateKontak(@Query("nim")nim:String, @Body mahasiswa: Mahasiswa)

    @DELETE("deletemahasiswa.php/{nim}")
    suspend fun deleteKontak(@Query("nim") nim:String): Response<Void>
}