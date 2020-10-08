package org.wit.utilities

import org.jetbrains.exposed.sql.ResultRow
import org.wit.db.Users
import org.wit.domain.UserDTO

fun mapToUserDTO(it: ResultRow) = UserDTO(
    id = it[Users.id],
    name = it[Users.name],
    email = it[Users.email]
)
