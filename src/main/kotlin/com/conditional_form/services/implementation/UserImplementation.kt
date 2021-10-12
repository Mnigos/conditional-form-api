package com.conditional_form.services.implementation

import com.conditional_form.entity.User
import com.conditional_form.model.response.DefaultResponse
import com.conditional_form.services.IUserImplementation
import org.litote.kmongo.coroutine.CoroutineClient
import org.litote.kmongo.eq

class UserImplementation(mongoClient: CoroutineClient) : IUserImplementation {

    private val databaseName = "conditional_form"
    private val database = mongoClient.getDatabase(databaseName)

    private val collectionName = "users"
    private val collection = database.getCollection<User>(collectionName)

    override suspend fun getAllUsers(): DefaultResponse<List<User>> {
        val users = collection.find().toList()

        return DefaultResponse(200, "Success", users)
    }

    override suspend fun getUser(_id: String): DefaultResponse<User> {
        val user = collection.findOne(User::_id eq _id)

        return DefaultResponse(200, "Success", user)
    }

    override suspend fun createUser(user: User): DefaultResponse<Boolean> {
        val newUser = User(
            name = user.name,
            formValues = user.formValues
        )

        return try {
            collection.insertOne(newUser)

            DefaultResponse(200, "Success", true)
        } catch (e: Exception) {
            DefaultResponse(500, "Error", false)
        }
    }

    override suspend fun updateUser(user: User): DefaultResponse<User> {
        return try {
            user._id?.let { collection.updateOne(it, user) }

            val updatedUser = user._id?.let { collection.findOne(it) }

            DefaultResponse(200, "Success", updatedUser)
        } catch (e: Exception) {
            DefaultResponse(500, "Error", null)
        }
    }

    override suspend fun deleteUser(_id: String): DefaultResponse<Boolean> {
        return try {
            collection.deleteOne(User::_id eq _id)

            DefaultResponse(200, "Success", true)
        } catch (e: Exception) {
            DefaultResponse(500, "Error", false)
        }
    }
}
