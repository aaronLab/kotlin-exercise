package chap11.section2

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

val lock = Mutex()

suspend fun doWork1(): String {
    lock.withLock {
        for (i in 1..2000) {
            println("work1: $i")
        }
        return "Work1"
    }
}

suspend fun doWork2(): String {
    lock.withLock {
        for (i in 1..2000) {
            println("work2: $i")
        }
        return "Work2"
    }
}

private fun worksInSerial() {
    // Serial Work
    GlobalScope.launch {
        val one = doWork1()
        val two = doWork2()
        println("Kotlin One: $one")
        println("Kotlin Tow: $two")
    }
}

fun main() = runBlocking<Unit> {
    launch {
        val one = doWork1()
        val two = doWork2()
        println("Kotlin One: $one")
        println("Kotlin Tow: $two")
    }
}