package com.example.project

import java.lang.Exception

class Calculator {

    fun add(n1: Int, n2: Int) = n1 + n2
    fun remove(n1: Int, n2: Int) = n1 - n2
    fun multiply(n1: Int, n2: Int) = n1 * n2
    fun divide(n1: Int, n2: Int) = try {
        n1 / n2
    } catch (e: Exception) {
        throw ArithmeticException("You can not divide by zero")
    }
}