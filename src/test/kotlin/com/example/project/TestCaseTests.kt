/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.example.project

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

// @see https://www.hackerrank.com/challenges/magic-square-forming/problem
class TestCaseTests {
    @Test
    fun `test case 1`(){
        val input = arrayOf(
                        arrayOf(4,5,8),
                        arrayOf(2,4,1),
                        arrayOf(1,9,7)
                    )
        assertEquals(14, formingMagicSquare(input))
    }
    @Test
    fun `test case 2`(){
                val input = arrayOf(
                arrayOf(2,9,8),
                arrayOf(4,2,7),
                arrayOf(5,6,7)
        )
        assertEquals(21, formingMagicSquare(input))
    }
}