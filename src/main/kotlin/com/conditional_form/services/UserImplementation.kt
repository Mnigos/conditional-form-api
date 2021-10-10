package com.conditional_form.services

import com.conditional_form.entity.User

interface UserImplementation {
    suspend fun getAllUsers()
    suspend fun getUser(_id: String)
    suspend fun createUser(user: User)
    suspend fun updateUser(user: User)
    suspend fun deleteUser(_id: String)
}
