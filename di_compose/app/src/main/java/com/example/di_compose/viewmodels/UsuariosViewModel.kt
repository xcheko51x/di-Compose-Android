package com.example.di_compose.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.di_compose.models.Usuario
import com.example.di_compose.repository.UsuariosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsuariosViewModel @Inject constructor(
    private val repository: UsuariosRepository
): ViewModel() {
    private val _listaUsuarios = MutableStateFlow(emptyList<Usuario>())
    val listaUsuarios: StateFlow<List<Usuario>> get() = _listaUsuarios

    init {
        viewModelScope.launch {
            _listaUsuarios.value = repository.obtenerUsuarios().usuarios
        }
    }
}