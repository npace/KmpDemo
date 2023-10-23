package com.npace.kmpdemo.server

import com.npace.kmpdemo.api.CheeseResponse
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.http.content.CompressedFileType
import io.ktor.server.http.content.staticResources
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import io.ktor.util.toLowerCasePreservingASCIIRules
import kotlinx.serialization.json.Json

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

private fun Application.module() {
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
        })
    }
    routing {
        get("/") {
            call.respond(CheesesData.cheeses.map {
                CheeseResponse(it, imagePath(it))
            })
        }
        staticResources("/static", "/static") {
            preCompressed(CompressedFileType.GZIP)
        }
    }
}

private fun imagePath(cheeseName: String): String {
    val fileName = "${cheeseName.toLowerCasePreservingASCIIRules()}.jpg"
    return "/static/images/$fileName"
}
