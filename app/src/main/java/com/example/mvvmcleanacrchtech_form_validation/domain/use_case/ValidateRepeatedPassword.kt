package com.example.mvvmcleanacrchtech_form_validation.domain.use_case

import android.util.Patterns

class ValidateRepeatedPassword {

    fun execute(password: String,repeatedPass : String) : ValidationResult{

        if (password != repeatedPass){
            return ValidationResult(success = false, errorMessage = "Password should same")
        }
        return ValidationResult(true)
    }
    
}