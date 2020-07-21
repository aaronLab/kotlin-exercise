package chap03.section5

fun main() {
    shortFunc(3) {println("First Call: $it")}
    shortFunc(5) {println("Second Call: $it")}
}

inline fun shortFunc(a: Int, out: (Int) -> Unit) {
    println("Before calling out()")
    out(a)
    println("After calling out()")
}