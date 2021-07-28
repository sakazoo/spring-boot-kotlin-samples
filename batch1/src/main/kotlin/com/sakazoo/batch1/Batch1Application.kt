package com.sakazoo.batch1

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class Batch1Application

fun main(args: Array<String>) {
    runApplication<Batch1Application>(*args)
}
