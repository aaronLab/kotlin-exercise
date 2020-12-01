class Person(private val first: String, private val middle: String?, private val last: String) {

    fun getFullName(): String {
        return "${this.first} ${this.middle ?: "\b"} ${this.last}"
    }

    fun printFullName() {
        println("My name is ${this.getFullName()}.")
    }

}

fun main() {
    val jkRowling = Person("Joanne", null, "Rowling")
    val northWest = Person("North", "East", "West")

    val jkRowlingFullName: String = jkRowling.getFullName()
    val northWetFullName: String = northWest.getFullName()

    jkRowling.printFullName()
    println(jkRowlingFullName)
    println()

    northWest.printFullName()
    println(northWetFullName)
}
