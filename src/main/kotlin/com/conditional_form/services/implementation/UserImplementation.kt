package com.conditional_form.services.implementation

import com.conditional_form.entity.User
import com.conditional_form.services.IUserImplementation
import org.litote.kmongo.coroutine.CoroutineClient

class UserImplementation(mongoClient: CoroutineClient) : IUserImplementation {

    private val databaseName = "conditional_form"
    private val database = mongoClient.getDatabase(databaseName)

    private val collectionName = "users"
    private val collection = database.getCollection<User>(collectionName)

    override suspend fun getAllUsers() {
        TODO("Not yet implemented")
    }

    override suspend fun getUser(_id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun createUser(user: User) {
        TODO("Not yet implemented")
    }

    override suspend fun updateUser(user: User) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteUser(_id: String) {
        TODO("Not yet implemented")
    }
}
