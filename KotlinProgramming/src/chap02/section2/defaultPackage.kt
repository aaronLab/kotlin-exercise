package chap02.section2

fun main() {
    val a = 1
    val str1 = "a = $a"
    val str2 = "a = ${a + 2}"

    println("str: \"$str1\", str2: \"$str2\"")
    println()

    val num = 10
    val formattedString = """
        var a = 6
        var b = "Kotlin"
        println(a + num)
    """.trimIndent()
    println(formattedString)
    println()
}