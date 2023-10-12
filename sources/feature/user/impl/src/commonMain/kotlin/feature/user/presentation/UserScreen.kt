package feature.user.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import base.compose.local.LocalNavigation
import base.compose.view.UploadingDialog
import coil3.compose.rememberAsyncImagePainter
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf
import startandroidarch.feature.user.impl.generated.resources.Res
import startandroidarch.feature.user.impl.generated.resources.user_back_icon
import startandroidarch.feature.user.impl.generated.resources.user_close_button
import startandroidarch.feature.user.impl.generated.resources.user_title

@Composable
fun UserScreen(
    userId: String,
    viewModel: UserViewModel = koinViewModel(
        parameters = {
            parametersOf(EXTRA_USER_ID to userId)
        },
    ),
) {
    val navController = LocalNavigation.current
    val state: UserState by viewModel.state.collectAsState()
    LaunchedEffect(key1 = viewModel) {
        viewModel.event.collect {
            when (it) {
                is UserEvent.NavigateBack -> navController.popBackStack()
            }
        }
    }
    if (state.itUploading) {
        UploadingDialog()
    }
    Screen(state = state, processor = viewModel::process)
}

@Composable
internal fun Screen(
    state: UserState,
    processor: (UserIntent) -> Unit = {},
) {
    Scaffold(
        topBar = {
            Toolbar()
        },
    ) { innerPadding ->
        Content(innerPadding = innerPadding, state = state, processor = processor)
    }
}

@Composable
private fun Content(
    innerPadding: PaddingValues,
    state: UserState,
    processor: (UserIntent) -> Unit
) {
    Box(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column {
            Image(
                painter = rememberAsyncImagePainter(state.user.photoUrl),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = state.fieldName,
                onValueChange = { processor(UserIntent.ChangeName(it)) },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                label = { Text("Name") }
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = state.fieldSurname,
                onValueChange = { processor(UserIntent.ChangeSurname(it)) },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                label = { Text("Surname") }
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = state.fieldEmail,
                onValueChange = { processor(UserIntent.ChangeEmail(it)) },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                label = { Text("Email") }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { processor(UserIntent.Save) }) {
                Text(text = "Save")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { processor(UserIntent.Delete) }) {
                Text(text = "Delete")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Toolbar() {
    val navController = LocalNavigation.current
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(stringResource(Res.string.user_title))
        },
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(
                    painter = painterResource(Res.drawable.user_back_icon),
                    contentDescription = stringResource(Res.string.user_close_button)
                )
            }
        }
    )
}
