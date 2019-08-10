/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package climbing.the.leaderboard

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

// @see https://www.hackerrank.com/challenges/magic-square-forming/problem
class TestCaseTests {
    @Test
    fun `sample1`(){
        val scores = arrayOf(100,100,50,40,40,20,10)
        val aliceScores = arrayOf(5,25,50,120)
        val expected = arrayOf(6,4,2,1)
        assertArrayEquals(expected,climbingLeaderboard(scores, aliceScores))
    }
    @Test
    fun `sample2`(){
        val scores = arrayOf(100,90,90,80,75,60)
        val aliceScores = arrayOf(50,65,77,90,102)
        val expected = arrayOf(6,5,4,2,1)
        assertArrayEquals(expected,climbingLeaderboard(scores, aliceScores))

    }
//    todo@shira: タイムアウトしているので速度を改善する

}