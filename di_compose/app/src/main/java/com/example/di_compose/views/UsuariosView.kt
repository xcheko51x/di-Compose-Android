package com.example.di_compose.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.di_compose.models.Usuario
import com.example.di_compose.viewmodels.UsuariosViewModel
import androidx.compose.runtime.getValue

@Composable
fun UsuariosView(
    paddingValues: PaddingValues,
    viewModel: UsuariosViewModel = hiltViewModel()
) {
    val listaUsuarios by viewModel.listaUsuarios.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        items(listaUsuarios) { usuario ->
            UsuarioCard(usuario)
        }
    }
}

@Composable
fun UsuarioCard(
    usuario: Usuario,
    modifier: Modifier = Modifier
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            Text(text = usuario.id.toString(), style = MaterialTheme.typography.bodySmall)
            Text(text = usuario.nombre.toString(), style = MaterialTheme.typography.bodyLarge)
            Text(text = usuario.correo.toString(), style = MaterialTheme.typography.bodyMedium)
        }
    }
}