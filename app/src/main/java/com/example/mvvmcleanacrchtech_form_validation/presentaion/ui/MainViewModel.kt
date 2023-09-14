package com.example.mvvmcleanacrchtech_form_validation.presentaion.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.mvvmcleanacrchtech_form_validation.domain.use_case.ValidateEmail
import com.example.mvvmcleanacrchtech_form_validation.domain.use_case.ValidatePassword
import com.example.mvvmcleanacrchtech_form_validation.domain.use_case.ValidateRepeatedPassword
import com.example.mvvmcleanacrchtech_form_validation.domain.use_case.ValidateTerms
import com.example.mvvmcleanacrchtech_form_validation.domain.use_case.ValidationResult
import com.example.mvvmcleanacrchtech_form_validation.presentaion.ui.model.RegisterState

class MainViewModel (
        private val validateEmail: ValidateEmail = ValidateEmail(),
        private val validatePassword: ValidatePassword = ValidatePassword(),
        private val validateRepeatedPassword: ValidateRepeatedPassword = ValidateRepeatedPassword(),
        private val validateTerms: ValidateTerms = ValidateTerms()
        ): ViewModel() {


    var state by mutableStateOf(RegisterState())


}