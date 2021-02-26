package chap03.section3

fun main() {
    var result: Int
    val multi = {x: Int, y: Int -> x * y}
    result = multi(2, 2)
    println(result)

    val multi2: (Int, Int) -> Int = {x: Int, y: Int ->
        println("x * y")
        x * y
    }
    result = multi2(2, 4)
    println(result)

    val greet: () -> Unit = {println("Hello Kotlin!")}
    val square: (Int) -> Int = {x -> x * x}
    greet()
    result = square(3)
    println(result)
}