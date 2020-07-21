package chap03.section3

fun main() {
    val out: () -> Unit = {println("Hello, Kotlin!")}
//    val out = {println("Hello, Kotlin!")}
    out()
    val new = out
    new()
}