package com.example.pertemuan12.ui.View

object DestinasiEntry :
    DestinasiNavigasi {
    override val route = "item_entry"
    override val titleRes = "Entry Mhs"
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntryMhsScreen(
    navigateBack: () -> Unit,
    modifier:
    Modifier = Modifier,
    viewModel: InsertViewModel = viewModel(factory = PenyediaViewModel.Factory)
){
    val coroutineScope = rememberCoroutineScope()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier =
        modifier.
        nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CostumeTopAppBar(
                title = DestinasiEntry.titleRes,
                canNavigateBack = true,
                scrollBehavior = scrollBehavior,
                navigateUp = navigateBack
            )
        }
    ){
            innerPadding ->
        EntryBody(
            insertUiState = viewModel.uiState,
            onSiswaValueChange = viewModel::updateInsertMhsState,
            onSaveClick = {
                coroutineScope.
                launch {
                    viewModel.insertMhs()
                    navigateBack()
                }
            },
            modifier = Modifier
                .
                padding(
                    innerPadding)
                .
                verticalScroll(rememberScrollState())
                .
                fillMaxWidth()
        )
    }
}

@Composable
fun EntryBody(
    insertUiState: InsertUiState,
    onSiswaValueChange: (InsertUiEvent) -> Unit,
    onSaveClick: () -> Unit,
    modifier:
    Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(18.
        dp),
        modifier =
        modifier.
        padding(12.
        dp)
    ) {
        FormInput(
            insertUiEvent =
            insertUiState.insertUiEvent,
            onValueChange =
            onSiswaValueChange,
            modifier = Modifier.
            fillMaxWidth()
        )
        Button(
            onClick =
            onSaveClick,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.
            fillMaxWidth()
        ) {
            Text(text = "Simpan")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormInput(
    insertUiEvent: InsertUiEvent,
    modifier:
    Modifier = Modifier,
    onValueChange: (InsertUiEvent) -> Unit = {},
    enabled: Boolean = true
){
    Column(
        modifier =
        modifier,
        verticalArrangement = Arrangement.spacedBy(12.
        dp)
    ) {
        OutlinedTextField(
            value = insertUiEvent.nama,
            onValueChange = { onValueChange(insertUiEvent.copy(nama = it)) },
            label = { Text("Nama") },
            modifier = Modifier.
            fillMaxWidth(),
            enabled =
            enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = insertUiEvent.nim,
            onValueChange = { onValueChange(insertUiEvent.copy(nim = it)) },
            label = { Text("NIM") },
            modifier = Modifier.
            fillMaxWidth(),
            enabled =
            enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = insertUiEvent.jenisKelamin,
            onValueChange = { onValueChange(insertUiEvent.copy(jenisKelamin = it)) },
            label = { Text("Jenis Kelamin") },
            modifier = Modifier.
            fillMaxWidth(),
            enabled =
            enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = insertUiEvent.alamat,
            onValueChange = { onValueChange(insertUiEvent.copy(alamat = it)) },
            label = { Text("Alamat") },
            modifier = Modifier.
            fillMaxWidth(),
            enabled =
            enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = insertUiEvent.kelas,
            onValueChange = { onValueChange(insertUiEvent.copy(kelas = it)) },
            label = { Text("Kelas") },
            modifier = Modifier.
            fillMaxWidth(),
            enabled =
            enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = insertUiEvent.angkatan,
            onValueChange = { onValueChange(insertUiEvent.copy(angkatan = it)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text("Angkatan") },
            modifier = Modifier.
            fillMaxWidth(),
            enabled =
            enabled,
            singleLine = true
        )
        if (
            enabled) {
            Text(
                text = "Isi Semua Data!",
                modifier = Modifier.
                padding(12.
                dp)
            )
        }
        Divider(
            thickness = 8.
            dp,
            modifier = Modifier.
            padding(12.
            dp)
        )
    }
}