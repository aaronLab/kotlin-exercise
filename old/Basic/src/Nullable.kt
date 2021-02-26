open class Person(val first: String, val middle: String?, val last: String, val age: Int) {

    fun getFullName(): String {
        return "${this.first} ${this.middle ?: "\b"} ${this.last}"
    }

    fun printFullName() {
        println("My name is ${this.getFullName()}.")
    }

}

class Baby(first: String, middle: String?, last: String, age: Int): Person(first, middle, last, age) {

    private val cannotWalk: Boolean = this.age < 2

    fun getDescription(): String {
        if (cannotWalk) {
            return "${getFullName()} is younger than 2. So cannot walk."
        }
        return "${getFullName()} is older than 1. So can walk."
    }

}

fun main() {
    val jkRowling = Person("Joanne", null, "Rowling", 30)
    val northWest = Baby("North", "East", "West", 1)
    val westNorth = Baby("West", "East", "North", 3)

    val people: Array<Person> = arrayOf(jkRowling, northWest, westNorth)
    val babies: ArrayList<Baby> = ArrayList()

    println()

    for (p in people) {
        p.printFullName()

        val middleNameLength = p.middle?.length ?: 0
        println("Middle name length: $middleNameLength")
        println("Middle Name: ${p.middle ?: "N/A"}")

        if (p.age <= 5) {
            babies.add(p as Baby)
        }

        println()
    }

    for (b in babies) {
        println("${b.getFullName()} is ${b.age} years old.")
        println(b.getDescription())
        println()
    }

}
