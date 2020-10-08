package org.wit.repository

import org.jetbrains.exposed.sql.*
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

    fun save(userDTO: UserDTO) : Int?{
        return transaction {
            Users.insert {
                it[name] = userDTO.name
                it[email] = userDTO.email
            } get Users.id
        }
    }

    fun findByEmail(email: String) :UserDTO?{
        return transaction {
            Users.select() {
                Users.email eq email}
                .map{mapToUserDTO(it)}
                .firstOrNull()
        }
    }

    fun update(id: Int, userDTO: UserDTO): Int{
        return transaction {
            Users.update ({
                Users.id eq id}) {
                it[name] = userDTO.name
                it[email] = userDTO.email
            }
        }
    }

    fun delete (id: Int): Int{
        return transaction{
            Users.deleteWhere { Users.id eq id }
        }
    }

}