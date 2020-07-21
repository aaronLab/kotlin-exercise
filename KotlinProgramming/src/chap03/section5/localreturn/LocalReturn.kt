package chap03.section5.localreturn

fun main() {
    shortFunc(3) {
        println("First call $it")
        return
    }
}

inline fun shortFunc(a: Int, out: (Int) -> Unit) {
    println("Before calling out()")
    println(a)
    println("After calling out()")
}