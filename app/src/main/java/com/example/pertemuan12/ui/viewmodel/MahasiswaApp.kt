package com.example.pertemuan12.ui.viewmodel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MahasiswaApp() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.
        nestedScroll(scrollBehavior.nestedScrollConnection),
// topBar = { TopAppBar(scrollBehavior = scrollBehavior) }
    ) {
        Surface(
            modifier = Modifier
                .
                fillMaxSize()
                .
                padding(it)
        ) {
            PengelolaHalaman()
        }
    }
}