package org.wit.config

import org.jetbrains.exposed.sql.Database
import java.net.URI

class DbConfig{

    //NOTE: you need the ?sslmode=require otherwise you get an error complaining about the ssl certificate
    /*fun getDbConnection() :Database{
        return Database.connect(
            "jdbc:postgresql://ec2-34-225-162-157.compute-1.amazonaws.com:5432/d1qu1323l55ule?sslmode=require",
            driver = "org.postgresql.Driver",
            user = "hnkxwzewsriise",
            password = "8eb243fe3522b4377aa928bfdca3b2faeac25cfa51ae148554e924ae963ef1ac")
    }*/
    fun getDbConnection() :Database{
        val databaseURL = URI(System.getenv("DATABASE_URL"))
        return Database.connect(
            "jdbc:postgresql://" + databaseURL.host + ":" + databaseURL.port + databaseURL.path + "?sslmode=require",
            driver = "org.postgresql.Driver",
            user = databaseURL.userInfo.split(":").toTypedArray()[0],
            password = databaseURL.userInfo.split(":").toTypedArray()[1])
    }

}
