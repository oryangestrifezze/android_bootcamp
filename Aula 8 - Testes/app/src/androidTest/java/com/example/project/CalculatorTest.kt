package com.example.project

import org.junit.Assert
import org.junit.Test

class CalculatorTest {

    @Test
    fun `add_test`() {
        val calculator = Calculator()
        val result = calculator.add(1,2)
        Assert.assertEquals(3,result)
    }
}