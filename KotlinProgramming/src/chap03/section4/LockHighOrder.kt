package chap03.section4

import java.util.concurrent.locks.ReentrantLock

var sharable = 1    // 보호가 필요한 공유 자원

fun main() {
    val reLock = ReentrantLock()

    lock(reLock, { criticalFunc()})     // 이하 lock 동일 식
    lock(reLock) { criticalFunc() }
    lock(reLock, ::criticalFunc)

    println(sharable)
}

fun criticalFunc() {
    // 공유 자원 접근 코드
    sharable += 1
}

// 함수 보호를 위해 제네릭 함수를 구현w
fun <T> lock(reLock: ReentrantLock, body: ()->T): T {
    reLock.lock()
    try{
        return body()
    } finally {
        reLock.unlock()
    }
}
