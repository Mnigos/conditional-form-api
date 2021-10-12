package com.conditional_form.model.response

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class DefaultResponse<T>(
    val code: Int,
    val status: String,
    var data: T?,
)
