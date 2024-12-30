package com.example.pertemuan12.repository


import com.example.pertemuan12.data.entity.Mahasiswa
import com.example.pertemuan12.service.MahasiswaService
import java.io.IOException

interface MahasiswaRepository {
    suspend fun getMahasiswa(): List<Mahasiswa>
    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)
    suspend fun updateMahasiswa(nim:String, mahasiswa: Mahasiswa)
    suspend fun deleteMahasiswa(nim: String)
    suspend fun getMahasiswaByNim(nim: String):Mahasiswa
}

class NetworkMahasiswaRepository(
    private val mahasiswaApiService: MahasiswaService
) : MahasiswaRepository{

    override suspend fun insertMahasiswa(mahasiswa: Mahasiswa) {
        mahasiswaApiService.insertMahasiswa(mahasiswa)
    }

    override suspend fun updateMahasiswa(nim: String, mahasiswa: Mahasiswa) {
        mahasiswaApiService.updateMahasiswa(nim, mahasiswa)
    }

    override suspend fun deleteMahasiswa(nim: String) {
        try {
            val response = mahasiswaApiService.deleteMahasiswa(nim)
            if (!response.isSuccessful) {
                throw IOException("Failed to delete mahasiswa. HTTP Status Code: " +
                        "${response.code()}")
            } else {
                response.message()
                println(response.message())
            }
        } catch (e:Exception){
            throw e
        }
    }

    override suspend fun getMahasiswa(): List<Mahasiswa> = mahasiswaApiService.getMahasiswa()

    override suspend fun getMahasiswaByNim(nim: String): Mahasiswa {
        return  mahasiswaApiService.getMahasiswaByNim(nim)
    }
}