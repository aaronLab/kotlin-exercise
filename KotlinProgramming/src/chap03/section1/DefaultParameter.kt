package chap03.section1

fun main() {
    val name = "Aaron"
    val email = "aaron@aa.ron"

    add(name)
    add(name, email)
    add("You", "you@y.ou")
    defaultArgs()
    defaultArgs(200)
}

fun add(name: String, email: String = "default") {
    val output = "${name}'s email is ${email}."
    println(output)
}

fun defaultArgs(x: Int = 100, y: Int = 200) {
    println(x+y)
}

