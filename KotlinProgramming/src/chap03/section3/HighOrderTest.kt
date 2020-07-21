package chap03.section3

// 변수에 할당하는 람다식 함수 작성(js에서 arrow function 이랑 비슷하네..)
fun main() {
    var result: Int
    val multi = {x: Int, y: Int -> x * y}       // 선언 자료형 생략
    result = multi(10, 20)
    println(result)
    println()

    val multi2: (Int, Int) -> Int = {x: Int, y: Int -> x * y}       // 생략없는 전체 표현
    val multi3: (Int, Int) -> Int = {x, y -> x * y}     // 람다식 매개변수 자료형의 생략
}