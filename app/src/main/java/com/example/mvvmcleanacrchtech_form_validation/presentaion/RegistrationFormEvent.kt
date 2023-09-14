package com.example.mvvmcleanacrchtech_form_validation.presentaion

sealed class RegistrationFormEvent{
    data class EmailChanged(val email : String) : RegistrationFormEvent()
    data class PasswordChange(val password : String) : RegistrationFormEvent()
    data class PasswordRepeatedError(val passwordRepeatedError: String) : RegistrationFormEvent()
    data class AcceptTerms(val isAccepted : Boolean) : RegistrationFormEvent()
    object Submit : RegistrationFormEvent()
}