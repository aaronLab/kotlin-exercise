package chap03.section1


fun max(a: Int, b: Int) = if (a > b) a else b

// 반환 값이 없는 함수(객체 반환)
fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}


fun main() {
    val num1 = 10
    val num2 = 3
    val result: Int

    result = max(num1, num2)
    println(result)

    printSum(num1, num2)

    println()
}
