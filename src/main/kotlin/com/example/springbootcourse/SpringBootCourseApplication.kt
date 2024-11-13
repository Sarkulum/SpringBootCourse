package com.example.springbootcourse

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class SpringBootCourseApplication

fun main(args: Array<String>) {
    runApplication<SpringBootCourseApplication>(*args) //Don't know why there is an error there. The code works fien as far as I know.
}