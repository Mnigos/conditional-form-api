package com.conditional_form.entity

import com.conditional_form.`interface`.FormValues

data class User(
    val _id: String,
    val name: String,
    val formValues: FormValues,
)
