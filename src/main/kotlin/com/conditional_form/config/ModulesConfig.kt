package com.conditional_form.config

import com.conditional_form.services.IUserImplementation
import com.conditional_form.services.implementation.UserImplementation
import com.typesafe.config.ConfigFactory
import io.ktor.config.HoconApplicationConfig
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import org.litote.kmongo.coroutine.CoroutineClient
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

fun DI.MainBuilder.bindMongoServices() {
    val hoconFile = HoconApplicationConfig(ConfigFactory.load())
    val mongoUrl = hoconFile.property("mongo.client").getString()

    bind<CoroutineClient>("mongoClient") with singleton { KMongo.createClient(mongoUrl).coroutine }
}

fun DI.MainBuilder.bindServices() {
    bind<IUserImplementation>() with singleton { UserImplementation(instance("mongoClient")) }
}
