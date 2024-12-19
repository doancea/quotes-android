package com.doancea.quotesapp.login

import javax.inject.Inject

class LoginRepository @Inject constructor(private val loginApi: LoginApi)  {

    suspend fun performLogin(username: String, password: String) {
        loginApi.performLogin(username, password)
    }
}
