package chap02.section3

fun main() {
//    var str1 : String = "Hello Kotlin"
//    str1 = null     // error
//    println("str1: $str1")

    var str1 : String? = "Hello Kotlin"
    str1 = null
//    println("str1: $str1, length: ${str1?.length}")
//    println("str1: $str1, length: ${str1!!.length}")    // NPE error

    // 조건식을 통해 null 상태 검사
//    val len = if(str1 != null) str1.length else -1
//    println("str1: $str1, length: $len")
    // 세이프 콜, elvis 연산자
    println("str1: $str1, length: ${str1?.length ?: -1}")
}