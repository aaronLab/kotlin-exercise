fun main() {
    val intVar: Int = 3
    val longVar: Long = intVar.toLong()
    val byteVar = intVar.toByte()
    val charVar = intVar.toChar()
    val shortVar = intVar.toShort()
    val floatVar = intVar.toFloat()
    val doubleVar = intVar.toDouble()

    println(longVar)
    println(byteVar)
    println(charVar)
    println(shortVar)
    println(floatVar)
    println(doubleVar)

    val longSum = 3L + intVar
    println(longSum)

}