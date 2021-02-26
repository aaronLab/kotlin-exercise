package chap02.section2

fun main() {
    val number = 10     // 자료형 추론
    var language = "English"
    val secondNumber: Int = 20
    language = "French"

    println("number: $number")
    println("language: $language")
    println("secondNumber: $secondNumber")
}