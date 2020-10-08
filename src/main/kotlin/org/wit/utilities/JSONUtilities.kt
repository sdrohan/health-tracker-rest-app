package org.wit.utilities

import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.joda.JodaModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kong.unirest.HttpResponse
import kong.unirest.JsonNode


inline fun <reified T: Any> jsonToObject(json: String) : T
        = jacksonObjectMapper()
    .registerModule(JodaModule())
    .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
    .readValue<T>(json)

inline fun <T> jsonToObjectWithDate(json : HttpResponse<JsonNode>, valueType: Class<T>) : T {
    return GsonBuilder().create().fromJson(json.body.toString(), valueType)
}

inline fun <T> jsonToArrayWithDate(json : HttpResponse<JsonNode>, valueType: Class<Array<T>>) : List<T> {
    return Gson().fromJson(json.body.toString(), valueType).toList()
}