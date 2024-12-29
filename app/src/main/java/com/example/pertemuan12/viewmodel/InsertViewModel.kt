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