package chap03.section1

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun main() {
    val result1 = sum(3, 2)
    var result2 = sum(6, 7)

    println(result1)
    println(result2)
}