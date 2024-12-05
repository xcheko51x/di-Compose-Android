package com.example.di_compose.api

import com.example.di_compose.models.UsuariosResponse
import retrofit2.http.GET

interface UsuariosApi {
    @GET("user.json")
    suspend fun obtenerUsuarios(): UsuariosResponse
}