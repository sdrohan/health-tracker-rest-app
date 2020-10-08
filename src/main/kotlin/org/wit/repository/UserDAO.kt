package org.wit.repository

import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.wit.db.Users
import org.wit.domain.UserDTO
import org.wit.utilities.mapToUserDTO

class UserDAO {

    fun getAll(): ArrayList<UserDTO> {
        val userList: ArrayList<UserDTO> = arrayListOf()
        transaction {
            Users.selectAll().map {
                userList.add(mapToUserDTO(it)) }
        }
        return userList
    }

    fun findById(id: Int): UserDTO?{
        return transaction {
            Users.select() {
                Users.id eq id}
                .map{mapToUserDTO(it)}
                .firstOrNull()
        }
    }

    fun save(userDTO: UserDTO){

    }

    fun findByEmail(email: String) :UserDTO?{
       return null
    }

    fun delete(id: Int) {

    }

    fun update(id: Int, userDTO: UserDTO){

    }

}