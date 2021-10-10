package com.conditional_form.entity

import com.conditional_form.interfaces.FormValues

data class User(
    val _id: String,
    val name: String,
    val formValues: FormValues,
)
