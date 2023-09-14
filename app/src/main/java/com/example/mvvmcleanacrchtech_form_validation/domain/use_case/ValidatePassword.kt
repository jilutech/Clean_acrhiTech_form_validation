package com.example.mvvmcleanacrchtech_form_validation.domain.use_case

import android.util.Patterns

class ValidatePassword {

    fun execute(password: String) : ValidationResult{

        if (password.length < 8){
            return ValidationResult(success = false, errorMessage = "Password need a 8 Char")
        }
        val containsLetterAndDigit = password.any { it.isDigit()  } && password.any{it.isLetter()}
        if (!containsLetterAndDigit){
            return ValidationResult(success = true, errorMessage = "Password should contain at least Digit an char")
        }
        return ValidationResult(true)
    }
    
}