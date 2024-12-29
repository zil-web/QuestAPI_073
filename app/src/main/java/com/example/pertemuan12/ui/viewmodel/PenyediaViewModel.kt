package com.example.pertemuan12.ui.viewmodel

object PenyediaViewModel {
    val Factory =
        viewModelFactory {
            initializer { HomeViewModel(
                aplikasiKontak().container.kontakRepository) }
            initializer { InsertViewModel(
                aplikasiKontak().container.kontakRepository) }
        }