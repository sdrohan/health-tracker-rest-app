package org.wit.repository

import org.wit.domain.UserDTO

class UserDAO {

    private val users = arrayListOf<UserDTO>(
        UserDTO(name = "Alice", email = "alice@wonderland.com", id = 0),
        UserDTO(name = "Bob", email = "bob@cat.ie", id = 1),
        UserDTO(name = "Mary", email = "mary@contrary.com", id = 2),
        UserDTO(name = "Carol", email = "carol@singer.com", id = 3)
    )

    fun getAll() : ArrayList<UserDTO>{
        return users
    }

    fun findById(id: Int): UserDTO?{
        return users.find {it.id == id}
    }

    fun save(userDTO: UserDTO){
        users.add(userDTO)
    }

    fun findByEmail(email: String) :UserDTO?{
        return users.find { it.email == email }
    }

    fun delete(id: Int) {
        var user = findById(id)
        users.remove(user)
    }

    fun update(id: Int, userDTO: UserDTO){
        var user = findById(id)
        user?.email = userDTO.email
        user?.name = userDTO.name
        user?.id = userDTO.id
    }

}