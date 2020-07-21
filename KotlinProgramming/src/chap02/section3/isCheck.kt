package chap02.section3

fun main() {
    val num = 256

    if (num is Int) {
        print(num)
    } else if (num !is Int) {
        print("NAN")
    }

    println()

    val x: Any
    x = "Hello"
    if (x is String) {
        print(x.length)
    }

    println()

//    val x: String = y as String       // 형변환 불가시 예외 발생
//    val x: String = y as? String      // null 가능성 고려하여 예외 발생 회피
}