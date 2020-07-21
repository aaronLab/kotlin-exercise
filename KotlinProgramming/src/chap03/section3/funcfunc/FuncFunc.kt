package chap03.section3.funcfunc

// 반환 값에 일반 함수 사용
fun main() {
    println("funcFunc: ${funcFunc()}")
}

fun sum(a: Int, b: Int) = a + b

fun funcFunc(): Int {
    return sum(2, 2)
}
