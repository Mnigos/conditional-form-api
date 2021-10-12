package com.conditional_form.services

import com.conditional_form.entity.User
import com.conditional_form.model.response.DefaultResponse

interface IUserImplementation {
    suspend fun getAllUsers(): DefaultResponse<List<User>>
    suspend fun getUser(_id: String): DefaultResponse<User>
    suspend fun createUser(user: User): DefaultResponse<Boolean>
    suspend fun updateUser(user: User): DefaultResponse<User>
    suspend fun deleteUser(_id: String): DefaultResponse<Boolean>
}
