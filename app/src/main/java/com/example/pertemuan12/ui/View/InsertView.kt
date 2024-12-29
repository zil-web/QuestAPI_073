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
)