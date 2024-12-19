package com.doancea.quotesapp.login

import retrofit2.Response
import retrofit2.http.POST

interface LoginApi {

    @POST("Login")
    suspend fun performLogin(username: String, password: String): Response<TastyLoginResponse>
}


data class TastyLoginResponse(val username: String, val password: String, val token: String)
