package chap02.section1

import kotlin.math.PI
import kotlin.math.abs

import com.example.edu.Person as User

fun line() {
    println("\n====================")
}

fun main() {
    val intro: String = "Hello!"
    val num: Int = 20
    println("intro: $intro, num: $num")
    line()

    println(PI)
    println(abs(-12.6))
    line()

    val user1 = User("Aaron", 20)
    println(user1.name)
    println(user1.age)
    line()

    val user2 = Person("A123", "PERSON")
    println(user2.id)
    println(user2.name)
    line()

    val number = 10
    var language = "Korean"
    val secondNumber: Int = 20
    language = "English"
    println("number: $number, language: $language, secondNumber: $secondNumber")
    line()

//    val num05 = 127 // int
//    val num06 = -32768  // int
//    val num07 = 2147483647 // int
//    val num08 = 837198367519836781  // long
//
//    val uint: UInt = 153u
//    val ushort: UShort = 64424u
//    val ulong: ULong = 46322342uL
//    val ubyte: UByte = 255u
//
//    val cardNum = 1234_1234_1234_1234L

    println("Byte min: ${Byte.MIN_VALUE}, max: ${Byte.MAX_VALUE}")
    line()

    val str1: String = "Hello"
    val str2 = "World"
    val str3 = "Hello"
    println("${str1 === str2}")
    println("${str1 === str3}")
    line()

    val special = "\"Hello\", I have \$15."
    val special2 = "${'"'}${'$'}9.99${'"'}"
    println(special)
    println(special2)
}

class Person(val id: String, val name: String)
