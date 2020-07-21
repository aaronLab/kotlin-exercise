package chap03.section1

fun main() {
    val name = "Aaron"
    val email = "aa@r.on"

    add(name)
    add(name, email)
    add("John", "jo@h.n")
    defaultArgs()
    defaultArgs(200)
}

fun add(name: String, email: String = "default"): Unit {
    val output = "$name's email address is ${if (email == "default") "$email." else email}"
    println(output)
}

fun defaultArgs(x: Int = 100, y: Int = 200): Unit {
    println(x + y)
}