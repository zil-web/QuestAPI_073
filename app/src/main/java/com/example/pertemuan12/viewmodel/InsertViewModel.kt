package com.example.pertemuan12.viewmodel

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