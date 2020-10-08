package org.wit.helpers

import org.wit.domain.UserDTO

val nonExistingEmail = "112233445566778testUser@xxxxx.xx"
val validName = "Test User 1"
val validEmail = "testuser1@test.com"

val users = arrayListOf<UserDTO>(
    UserDTO(name = "Alice Wonderland", email = "alice@wonderland.com", id = 1),
    UserDTO(name = "Bob Cat", email = "bob@cat.ie", id = 2),
    UserDTO(name = "Mary Contrary", email = "mary@contrary.com", id = 3),
    UserDTO(name = "Carol Singer", email = "carol@singer.com", id = 4)
)