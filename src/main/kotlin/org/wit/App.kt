package org.wit

import org.wit.config.DbConfig
import org.wit.config.JavalinConfig

fun main() {

    DbConfig().getDbConnection()
    JavalinConfig().startJavalinService()
}