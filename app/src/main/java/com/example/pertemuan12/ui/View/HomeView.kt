package com.example.pertemuan12.ui.View

object DestinasiHome :
    DestinasiNavigasi {
    override val route = "home"
    override val titleRes = "Home Mhs"
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateToItemEntry: () -> Unit,
    modifier:
    Modifier = Modifier,
    onDetailClick: (String) -> Unit = {},
    viewModel: HomeViewModel = viewModel(factory = PenyediaViewModel.Factory)
){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier =
        modifier.
        nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CostumeTopAppBar(
                title = DestinasiHome.titleRes,
                canNavigateBack = false,
                scrollBehavior = scrollBehavior,
                onRefresh = {
                    viewModel.getMhs()
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToItemEntry,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.
                padding(18.
                dp)
            ) {
                Icon(imageVector = Icons.Default.
                Add, contentDescription = "Add Kontak")
            }
        },
    ){
            innerPadding ->
        HomeStatus(
            homeUiState = viewModel.mhsUIState,
            retryAction = { viewModel.getMhs() }, modifier = Modifier.
            padding(
                innerPadding),
            onDetailClick = onDetailClick, onDeleteClick = {
                viewModel.deleteMhs(it.nim )
                viewModel.getMhs()
            }
        )
    }
}


@Composable
fun HomeStatus(
    homeUiState: HomeUiState,
    retryAction: () -> Unit,
    modifier:
    Modifier = Modifier,
    onDeleteClick: (Mahasiswa) -> Unit = {},
    onDetailClick: (String) -> Unit
)
{
    when (
        homeUiState) {
        is HomeUiState.Loading -> OnLoading(modifier =
        modifier.
        fillMaxSize())
        is HomeUiState.Success ->
            if (
                homeUiState.mahasiswa.isEmpty()){
                return Box(modifier =
                modifier.
                fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = "Tidak ada data Kontak" )
                }
            }else {
                MhsLayout(
                    mahasiswa =
                    homeUiState.mahasiswa, modifier =
                    modifier.
                    fillMaxWidth(),
                    onDetailClick = {
                        onDetailClick(it.nim)
                    },
                    onDeleteClick = {
                        onDeleteClick(it)
                    }
                )
            }
        is HomeUiState.Error -> OnError(
            retryAction, modifier =
            modifier.
            fillMaxSize())
    }
}



@Composable
fun OnLoading(
    modifier:
    Modifier = Modifier) {
    Image(
        modifier =
        modifier.
        size(200.
        dp),
        painter = painterResource(R.drawable.
        loading_img),
        contentDescription = stringResource(R.string.
        loading)
    )
}

@Composable
fun OnError(
    retryAction: () -> Unit,
    modifier:
    Modifier = Modifier) {
    Column(
        modifier =
        modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.
            ic_connection_error), contentDescription = ""
        )
        Text(text = stringResource(R.string.
        loading_failed), modifier = Modifier.
        padding(16.
        dp))
        Button(onClick =
        retryAction) {
            Text(stringResource(R.string.
            retry))
        }
    }
}

@Composable
fun MhsLayout(
    mahasiswa:
    List<Mahasiswa>,
    modifier:
    Modifier = Modifier,
    onDetailClick: (Mahasiswa) -> Unit,
    onDeleteClick: (Mahasiswa) -> Unit = {}
)