package com.example.mvvmcleanacrchtech_form_validation.domain.use_case

import android.util.Patterns

class ValidateTerms {

    fun execute(acceptedTerms: Boolean) : ValidationResult{

        if (!acceptedTerms){
            return ValidationResult(success = false, errorMessage = "Please accept terms")
        }
        return ValidationResult(true)
    }
    
}