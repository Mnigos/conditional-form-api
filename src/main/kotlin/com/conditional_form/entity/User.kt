package com.conditional_form.entity

import com.conditional_form.`interface`.FormValues
import org.bson.codecs.pojo.annotations.BsonId
import java.time.LocalDateTime
import java.util.UUID

data class User(
    @BsonId
    val _id: String? = UUID.randomUUID().toString(),
    val name: String,
    val formValues: FormValues,
    val createdAt: LocalDateTime? = LocalDateTime.now()
)
