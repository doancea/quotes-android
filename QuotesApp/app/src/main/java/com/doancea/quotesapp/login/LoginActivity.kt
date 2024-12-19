package com.doancea.quotesapp.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.doancea.quotesapp.theme.QuotesAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: LoginViewModel by viewModels()

        enableEdgeToEdge()
        setContent {
            QuotesAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    LoginForm(viewModel.submitLogin)
                }
            }
        }
    }
}