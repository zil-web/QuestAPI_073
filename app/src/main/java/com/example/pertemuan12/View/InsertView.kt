package com.example.pertemuan12.View

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pertemuan12.costumwidget.CostumTopAppBar
import com.example.pertemuan12.navigation.DestinasiNavigasi
import com.example.pertemuan12.viewmodel.InsertUiEvent
import com.example.pertemuan12.viewmodel.InsertUiState
import com.example.pertemuan12.viewmodel.InsertViewModel
import com.example.pertemuan12.viewmodel.PenyediaViewModel

import kotlinx.coroutines.launch

object DestinasiEntry : DestinasiNavigasi {
    override val route = "item_entry"
    override val titleRes = "Entry Mhs"
}

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun EntryMhsScreen(
    navigateBack:() -> Unit,
    modifier: Modifier =Modifier,
    viewModel: InsertViewModel = viewModel(factory = PenyediaViewModel.Factory )
) {
    val coroutineScope = rememberCoroutineScope()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold (
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CostumTopAppBar(
                title = DestinasiEntry.titleRes,
                canNavigateBack = true,
                scrollBehavior = scrollBehavior,
                navigateUp = navigateBack
            )
        }
    ){ innerPadding ->
        EntryBody(
            insertUiState = viewModel.uiState,
            onSiswaValueChange = viewModel::updateInsertMhsState,
            onSaveClick = {
                coroutineScope.launch {
                    viewModel.insertMhs()
                    navigateBack()
                }
            },
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        )

    }

}

@Composable
fun EntryBody(
    insertUiState: InsertUiState,
    onSiswaValueChange: (InsertUiEvent) -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier =Modifier
){
    Column (
        verticalArrangement = Arrangement.spacedBy(18.dp),
        modifier = modifier.padding(12.dp)
    ) {
        FormInput(
            insertUiEvent = insertUiState.insertUiEvent,
            onValueChange = onSiswaValueChange,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = onSaveClick,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Simpan")
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormInput(
    insertUiEvent: InsertUiEvent,
    modifier: Modifier =Modifier,
    onValueChange:(InsertUiEvent) -> Unit = {},
    enabled:Boolean = true
) {
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        OutlinedTextField(
            value = insertUiEvent.nama,
            onValueChange = {onValueChange(insertUiEvent.copy(nama = it))},
            label = { Text("Nama") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )

        OutlinedTextField(
            value = insertUiEvent.nim,
            onValueChange = {onValueChange(insertUiEvent.copy(nim = it))},
            label = { Text("Nim") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )

        OutlinedTextField(
            value = insertUiEvent.jenisKelamin,
            onValueChange = {onValueChange(insertUiEvent.copy(jenisKelamin = it))},
            label = { Text("Jenis Kelamin") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )

        OutlinedTextField(
            value = insertUiEvent.alamat,
            onValueChange = {onValueChange(insertUiEvent.copy(alamat = it))},
            label = { Text("Alamat") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )

        OutlinedTextField(
            value = insertUiEvent.kelas,
            onValueChange = {onValueChange(insertUiEvent.copy(kelas = it))},
            label = { Text("kelas") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )

        OutlinedTextField(
            value = insertUiEvent.angkatan,
            onValueChange = {onValueChange(insertUiEvent.copy(angkatan = it))},
            label = { Text("Angkatan") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        if (enabled){
            Text(
                text = "Isi semua data!",
                modifier = Modifier.padding(12.dp)
            )
        }
        Divider(
            thickness = 8.dp,
            modifier = Modifier.padding(12.dp)
        )

    }
}