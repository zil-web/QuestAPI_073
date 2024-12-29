package com.example.pertemuan12.viewmodel

import com.example.pertemuan12.entity.Mahasiswa

sealed class HomeUiState {
    data class Success(val mahasiswa:
                       List<Mahasiswa>) : HomeUiState()
    object Error : HomeUiState()
    object Loading : HomeUiState()
}