package com.sakazoo.externalapp1

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ExternalApp1Application

fun main(args: Array<String>) {
    runApplication<ExternalApp1Application>(*args)
}
