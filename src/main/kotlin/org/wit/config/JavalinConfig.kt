package org.wit.config

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import org.wit.controllers.HealthTrackerAPI

class JavalinConfig {

    fun startJavalinService(): Javalin {

        val app = Javalin.create().apply {
            exception(Exception::class.java) { e, ctx -> e.printStackTrace() }
            error(404) { ctx -> ctx.json("404 - Not Found") }
        }.start(7000)

        registerRoutes(app)
        return app
    }

    private fun registerRoutes(app: Javalin){
        app.routes {
            get("/api/users", HealthTrackerAPI::getAllUsers)
            get("/api/users/:user-id", HealthTrackerAPI::getUserByUserId)
            post("/api/users", HealthTrackerAPI::addUser)
        }
    }

}