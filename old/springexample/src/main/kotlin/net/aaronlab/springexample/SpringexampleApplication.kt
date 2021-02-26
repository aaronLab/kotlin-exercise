package net.aaronlab.springexample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringexampleApplication

fun main(args: Array<String>) {
    runApplication<SpringexampleApplication>(*args)
}
