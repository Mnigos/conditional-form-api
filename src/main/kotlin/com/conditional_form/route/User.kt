package com.conditional_form.route

import com.conditional_form.entity.User
import com.conditional_form.services.IUserImplementation
import io.ktor.application.call
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.*
import org.kodein.di.instance
import org.kodein.di.ktor.di

fun Route.userRoute() {

    val userImplementation by di().instance<IUserImplementation>()

    route("user") {

        get {
            return@get call.respond(
                userImplementation.getAllUsers()
            )
        }

        get("{id}") {
            val param = call.parameters["id"] ?: return@get call.respond(
                400
            )

            return@get call.respond(userImplementation.getUser(param))
        }

        post {
            val body = call.receive<User>()

            return@post call.respond(userImplementation.createUser(body))
        }

        put {
            val body = call.receive<User>()

            return@put call.respond(userImplementation.updateUser(body))
        }

        delete("{id}") {
            val param = call.parameters["id"] ?: return@delete call.respond(
                400
            )

            return@delete call.respond(userImplementation.getUser(param))
        }
    }
}
