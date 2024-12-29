package com.example.pertemuan12.ui.viewmodel

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pertemuan12.data.entity.Mahasiswa
import com.example.pertemuan12.repository.MahasiswaRepository
import kotlinx.coroutines.launch
import java.io.IOException

sealed class HomeUiState {
    data class Success(val mahasiswa:
                       List<Mahasiswa>) : HomeUiState()
    object Error : HomeUiState()
    object Loading : HomeUiState()
}
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
class HomeViewModel(private val mhs:
                    MahasiswaRepository
) : ViewModel() {
    var mhsUIState: HomeUiState by
    mutableStateOf(HomeUiState.Loading)
        private set
    init {
        getMhs()
    }
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun getMhs() {
        viewModelScope.
        launch {
            mhsUIState = HomeUiState.Loading
            mhsUIState = try {
                HomeUiState.Success(mhs.getMahasiswa())
            } catch (e: IOException) {
                HomeUiState.Error
            } catch (e: HttpException) {
                HomeUiState.Error
            }
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun deleteMhs(
        nim: String) {
        viewModelScope.
        launch {
            try {
                mhs.deleteMahasiswa(nim)
            } catch (e: IOException){
                HomeUiState.Error
            } catch (e:HttpException){
                HomeUiState.Error
            }
        }
    }
}
