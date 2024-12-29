package com.example.pertemuan12.ui.navigation

@Composable
fun PengelolaHalaman(
    navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier,
    )