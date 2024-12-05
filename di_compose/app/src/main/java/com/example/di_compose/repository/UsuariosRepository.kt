package com.example.di_compose.repository

import com.example.di_compose.api.UsuariosApi
import com.example.di_compose.models.UsuariosResponse
import javax.inject.Inject

class UsuariosRepository @Inject constructor(
    private val usuariosApi: UsuariosApi
){
    suspend fun obtenerUsuarios(): UsuariosResponse {
        return usuariosApi.obtenerUsuarios()
    }
}