fun main() {
    /*
    There are 10 kinds of people.
    Those who know binary, and those who don't.
     */

    val joke = """
        Actually, there are ${2.toString(2)} kinds of people.
        Those who know binary, and those who don't.
        And those who didn't realize this actually a ternary joke.
    """.trimIndent()

    println(joke)
}