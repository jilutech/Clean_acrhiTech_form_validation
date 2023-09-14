package com.example.mvvmcleanacrchtech_form_validation.domain.use_case

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class ValidatePasswordTest {

    private lateinit var valdatePassword : ValidatePassword
    @Before
    fun setUp() {
        valdatePassword = ValidatePassword()
    }

    @Test
    fun `password only have letter, return error`(){
        val result = valdatePassword.execute("ansks")

        assertEquals(result.success, false)
    }
}