package com.example.mvvmcleanacrchtech_form_validation.presentaion.ui.model

data class RegisterState(
    val email : String = "",
    val emailError: String? = null,
    val password : String = "",
    val passwordError : String? = null,
    val repeatedPassword : String = "",
    val repeatedPasswordError : String? =null,
    val acceptedTerms: Boolean = false,
    val termsError: String? = null

)