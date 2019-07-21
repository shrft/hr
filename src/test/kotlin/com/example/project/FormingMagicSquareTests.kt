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
class FormingMagicSquareTests {
    @Test
    fun `test if square is same`(){
        var input1 = arrayOf(arrayOf(1,2,3), arrayOf(4,5,6), arrayOf(7,8,9))
        var input2 = arrayOf(arrayOf(1,2,3), arrayOf(4,5,6), arrayOf(7,8,9))
        var s1 = Square(input1)
        var s2 = Square(input2)
        assertTrue(s1.isEqualTo(s2))

        var input3 = arrayOf(arrayOf(2,2,3), arrayOf(4,5,6), arrayOf(7,8,9))
        var s3 = Square(input3)
        assertFalse(s1.isEqualTo(s3))
    }
    @Test
    fun `test if square is a magic square`(){
        var input1 = arrayOf(arrayOf(8,3,4), arrayOf(1,5,9), arrayOf(6,7,2))
        var s = Square(input1)
        assertTrue(s.isMagicSquare());

        var input2 = arrayOf(arrayOf(8,3,4), arrayOf(1,5,9), arrayOf(6,7,3))
        var m = Square(input2)
        assertFalse(m.isMagicSquare());
    }
    @Test
    fun `test get all combination from string`(){
//        var s = "123"
        var s = arrayListOf(1,2,3)
        val c = Combination(s);
        var patterns = c.all()

        val expected = arrayListOf(
                arrayListOf(1,2,3),
                arrayListOf(1,3,2),
                arrayListOf(2,1,3),
                arrayListOf(2,3,1),
                arrayListOf(3,1,2),
                arrayListOf(3,2,1)
        )

        for((index,expectedRow) in expected.withIndex()){
            assertEquals(expected[index], patterns[index].toList())
        }
    }
    @Test
    fun `test calulating cost to convert to magic square`(){
        var a = Square(
                arrayOf(arrayOf(1,2,3), arrayOf(4,5,6), arrayOf(7,8,9))
        )
        var b = Square(
                arrayOf(arrayOf(1,2,3), arrayOf(4,5,6), arrayOf(7,8,9))
        )
        assertEquals(0, Calc().cost(a,b))

        var c = Square(
                arrayOf(arrayOf(1,1,3), arrayOf(2,6,6), arrayOf(7,8,8))
        )
        assertEquals(5, Calc().cost(a,c))

    }
    @Test
    fun `test pattern 1 `(){
        val input = arrayOf(
                arrayOf(4,9,2),
                arrayOf(3,5,7),
                arrayOf(8,1,5)
        )
        assertEquals(1, formingMagicSquare(input))
    }
        @Test
    fun `test pattern 2 `(){
        val input = arrayOf(
                arrayOf(4,8,2),
                arrayOf(4,5,7),
                arrayOf(6,1,6)
        )
        assertEquals(4, formingMagicSquare(input))
    }
}