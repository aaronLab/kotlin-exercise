package chap03.section3

// 인자와 반환 값이 없는 람다식 함수
fun main() {
    val out: () -> Unit = { println("Hello World!")}    // 인자와 반환 값이 없는 람다식 선언
    // 자료형 추론이 가능하므로 이와 같이 생략 가능

    out()
    val new = out
    new()
}