package chap11.section2

import kotlinx.coroutines.*

suspend fun doSomething() {
    println("Do Something.")
}

fun main() {  // Main Thread
    GlobalScope.launch {  // new coroutine on background
//        delay(1000L)
//        println("World!")
        doSomething()
    }
    println("Hello, ")
    Thread.sleep(2000L)
}