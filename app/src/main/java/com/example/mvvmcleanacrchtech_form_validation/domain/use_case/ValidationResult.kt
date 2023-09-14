package com.example.mvvmcleanacrchtech_form_validation.domain.use_case

data class ValidationResult(
    val success : Boolean ,
    val errorMessage : String ? = null
)