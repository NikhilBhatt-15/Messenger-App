package com.example.loginpages.app.rules

object Validator {

    fun validateFirstName(fName:String):ValidationResult{
        return ValidationResult(
            !fName.isNullOrEmpty() && fName.length>=4
        )
    }
    fun validateLastName(lName:String):ValidationResult{
        return ValidationResult(
            !lName.isNullOrEmpty() && lName.length>=4
        )
    }
    fun validateEmail(email:String):ValidationResult{
        return ValidationResult(
            !email.isNullOrEmpty() && email.endsWith("@gmail.com")
        )
    }
    fun validatePassword(password:String):ValidationResult{
        return ValidationResult(
            !password.isNullOrEmpty() && password.length>=5
        )
    }

}

data class ValidationResult(
    val isValid:Boolean
)