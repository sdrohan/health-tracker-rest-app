package org.wit.utilities

import org.jetbrains.exposed.sql.ResultRow
import org.wit.db.Users
import org.wit.domain.UserDTO
import org.wit.db.Activities
import org.wit.domain.ActivityDTO

fun mapToUserDTO(it: ResultRow) = UserDTO(
    id = it[Users.id],
    name = it[Users.name],
    email = it[Users.email]
)

fun mapToActivityDTO(it: ResultRow) = ActivityDTO(
    id = it[Activities.id],
    description = it[Activities.description],
    duration = it[Activities.duration],
    started = it[Activities.started],
    calories = it[Activities.calories],
    userId = it[Activities.userId]
)
