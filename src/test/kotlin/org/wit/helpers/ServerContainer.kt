package org.wit.helpers

import org.wit.config.JavalinConfig

object ServerContainer {

    val instance by lazy {
        startServerContainer()
    }

    private fun startServerContainer() = JavalinConfig().startJavalinService()

}