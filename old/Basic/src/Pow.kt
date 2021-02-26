import kotlin.math.pow

infix fun Int. `**`(x: Int) = toDouble().pow(x).toInt()
infix fun Long. `**`(x: Int) = toDouble().pow(x).toLong()
infix fun Float. `**`(x: Int) = toDouble().pow(x)
infix fun Double. `**`(x: Int) = toDouble().pow(x)

fun main() {
    val pow2 = 2 `**` 4
    print(pow2)
}
