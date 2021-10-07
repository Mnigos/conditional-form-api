package com.conditional_form

import com.conditional_form.plugins.configureHTTP
import com.conditional_form.plugins.configureRouting
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
        configureHTTP()
    }.start(wait = true)
}
