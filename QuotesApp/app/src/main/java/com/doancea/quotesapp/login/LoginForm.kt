package com.doancea.quotesapp.login

import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.doancea.quotesapp.R

@Composable
fun LoginForm(loginClickHandler: (LoginCredentials) -> Unit) {
    Surface {
        var loginCredentials by remember { mutableStateOf(LoginCredentials()) }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
        ) {
            LoginField(
                value = "",
                onChange = { data ->
                    loginCredentials = loginCredentials.copy(username = data)
                },
            )
            PasswordField(
                value = "",
                onChange = { data ->
                    loginCredentials = loginCredentials.copy(password = data)
                },
                submit = { },
            )
            Button(
                onClick = {
                    if(loginCredentials.areProvided) {
                        loginClickHandler(loginCredentials)
                    }
                },
                enabled = loginCredentials.areProvided,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(stringResource(R.string.login_form_submit_button_label_text))
            }
        }
    }
}

@Composable
fun LoginField(
    value: String,
    onChange: (String) -> Unit,
    label: String = stringResource(R.string.default_login_label_text),
    placeholder: String = stringResource(R.string.login_username_field_placeholder_text)
) {
    val focusManager = LocalFocusManager.current

    TextField(
        value = value,
        onValueChange = onChange,
        leadingIcon = null,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        keyboardActions = KeyboardActions(
            onNext = { focusManager.moveFocus(FocusDirection.Down) }
        ),
        placeholder = { Text(placeholder) },
        label = { Text(label) },
        singleLine = true,
        visualTransformation = VisualTransformation.None
    )

}

@Composable
fun PasswordField(
    value: String,
    onChange: (String) -> Unit,
    submit: () -> Unit,
    label: String = stringResource(R.string.login_password_label_text),
    placeholder: String = stringResource(R.string.login_password_placeholder_text)
) {
    TextField(
        value = value,
        onValueChange = onChange,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password
        ),
        keyboardActions = KeyboardActions(
            onDone = { submit() }
        ),
        placeholder = { Text(placeholder) },
        label = { Text(label) },
        singleLine = true,
    )
}

data class LoginCredentials(
    val username: String? = null,
    val password: String? = null
) {
    val areProvided: Boolean
        get() = username != null && password != null
}