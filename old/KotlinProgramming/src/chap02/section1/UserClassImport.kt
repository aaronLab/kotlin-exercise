package chap02.section1

import com.example.edu.Person as User

fun main() {
    val user1 = User("Aaron", 20)
    val user2 = Person("A123", "Aaron")

    println(user1.name)
    println(user1.age)

    println(user2.id)
    println(user2.name)
}

class Person(val id: String, val name: String)