package com.example.springbootcourse

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootCourseApplication

fun main(args: Array<String>) {
    runApplication<SpringBootCourseApplication>(*args) //Don't know why there is an error there. The code works fien as far as I know.
}