package com.doancea.quotesapp.login

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository
): ViewModel() {


    var submitLogin: (LoginCredentials) -> Unit = { credentials ->

//        {
//            with(credentials) {
//                loginRepository.performLogin(username, password)
//            }
//        }
    }
}