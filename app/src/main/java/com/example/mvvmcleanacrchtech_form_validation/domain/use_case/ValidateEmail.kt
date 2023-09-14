package com.example.mvvmcleanacrchtech_form_validation.domain.use_case

import android.util.Patterns

class ValidateEmail {

    fun execute(email: String) : ValidationResult{

        if (email.isBlank()){
            return ValidationResult(success = false, errorMessage = "Email Can not be blank")
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return ValidationResult(success = true, errorMessage = "This is not valid email")
        }
        return ValidationResult(true)
    }

}