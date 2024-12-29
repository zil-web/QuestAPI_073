package com.example.pertemuan12.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pertemuan12.entity.Mahasiswa
import com.example.pertemuan12.repository.MahasiswaRepository

class InsertViewModel(private val mhs:
                      MahasiswaRepository) : ViewModel() {
    var uiState by
    mutableStateOf(InsertUiState())
        private set
    fun updateInsertMhsState(
        insertUiEvent: InsertUiEvent) {
        uiState = InsertUiState(insertUiEvent =
        insertUiEvent)
    }

    suspend fun insertMhs() {
        viewModelScope.
        launch {
            try {
                mhs.insertMahasiswa(uiState.insertUiEvent.
                toMhs())
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }
}
data class InsertUiState(
    val insertUiEvent: InsertUiEvent = InsertUiEvent()
)

data class InsertUiEvent(
    val nim: String = "",
    val nama: String = "",
    val alamat: String = "",
    val jenisKelamin: String = "",
    val kelas: String = "",
    val angkatan: String = ""
)

fun InsertUiEvent.toMhs(): Mahasiswa = Mahasiswa(
    nim = nim,
    nama = nama,
    alamat = alamat,
    jenisKelamin = jenisKelamin,
    kelas = kelas,
    angkatan = angkatan
)


fun Mahasiswa.toUiStateMhs(): InsertUiState = InsertUiState(
    insertUiEvent =
    toInsertUiEvent()
)

fun Mahasiswa.toInsertUiEvent(): InsertUiEvent = InsertUiEvent(
    nim = nim,
    nama = nama,
    alamat = alamat,
    jenisKelamin = jenisKelamin,
    kelas = kelas,
    angkatan = angkatan
)