package com.example.mvvmcleanacrchtech_form_validation.presentaion.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmcleanacrchtech_form_validation.domain.use_case.ValidateEmail
import com.example.mvvmcleanacrchtech_form_validation.domain.use_case.ValidatePassword
import com.example.mvvmcleanacrchtech_form_validation.domain.use_case.ValidateRepeatedPassword
import com.example.mvvmcleanacrchtech_form_validation.domain.use_case.ValidateTerms
import com.example.mvvmcleanacrchtech_form_validation.domain.use_case.ValidationResult
import com.example.mvvmcleanacrchtech_form_validation.presentaion.RegistrationFormEvent
import com.example.mvvmcleanacrchtech_form_validation.presentaion.ui.model.RegisterState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class MainViewModel (
        private val validateEmail: ValidateEmail = ValidateEmail(),
        private val validatePassword: ValidatePassword = ValidatePassword(),
        private val validateRepeatedPassword: ValidateRepeatedPassword = ValidateRepeatedPassword(),
        private val validateTerms: ValidateTerms = ValidateTerms()
        ): ViewModel() {


    var state by mutableStateOf(RegisterState())

    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    fun onEvent(event: RegistrationFormEvent){
            when(event){
                    is RegistrationFormEvent.EmailChanged -> {
                            state = state.copy(email = event.email)
                    }
                    is RegistrationFormEvent.PasswordChange -> {
                            state = state.copy(password = event.password)

                    }
                    is RegistrationFormEvent.PasswordRepeatedError -> {
                            state = state.copy(repeatedPassword = event.passwordRepeatedError)

                    }
                    is RegistrationFormEvent.AcceptTerms -> {
                            state = state.copy(acceptedTerms = event.isAccepted)

                    }
                    is RegistrationFormEvent.Submit -> {
                          submitData()
                    }
            }
    }

    private fun submitData() {
        val emailResult = validateEmail.execute(state.email)
        val password = validatePassword.execute(state.password)
        val repeatedPassword = validateRepeatedPassword.execute(state.password,state.repeatedPassword)
        val terms = validateTerms.execute(state.acceptedTerms)

        val hasResult = listOf(
                emailResult,
                password,
                repeatedPassword,
                terms
        ).any {
                !it.success
        }
        state = state.copy(
            emailError = emailResult.errorMessage,
            passwordError = password.errorMessage,
            repeatedPasswordError = repeatedPassword.errorMessage,
            termsError = terms.errorMessage
        )

        if (hasResult)
                return
      viewModelScope.launch {
              validationEventChannel.send(ValidationEvent.Success)
      }

}

    sealed class ValidationEvent {
        object Success: ValidationEvent()
    }


}