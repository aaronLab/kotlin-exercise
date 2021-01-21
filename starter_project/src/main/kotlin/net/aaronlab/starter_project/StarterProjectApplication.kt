package net.aaronlab.starter_project

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StarterProjectApplication

fun main(args: Array<String>) {
    runApplication<StarterProjectApplication>(*args)
}
