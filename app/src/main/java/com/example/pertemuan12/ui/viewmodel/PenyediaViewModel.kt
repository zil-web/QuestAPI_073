package com.example.pertemuan12.ui.viewmodel

object PenyediaViewModel {
    val Factory =
        viewModelFactory {
            initializer { HomeViewModel(
                aplikasiKontak().container.kontakRepository) }
            initializer { InsertViewModel(
                aplikasiKontak().container.kontakRepository) }
        }
    fun CreationExtras.aplikasiKontak(): MahasiswaApplications =
        (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaApplications