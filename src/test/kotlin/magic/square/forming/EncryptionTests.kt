
/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package magic.square.forming

import org.junit.jupiter.api.Assertions.assertEquals

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

/**
 *
 * 2019/06/09 多分2,3時間かかった。kotlinの勉強はじめたばっかりだったので。
 * 次の目標: 30分以内
 * @see https://www.hackerrank.com/challenges/encryption/problem
 */
class EncryptionTests {
    @Test
    fun `encrypt it`() {
        var s:String =  "feedthedog"
        assertEquals("fto ehg ee dd", Encryption(s).run(), "not encripted")
   }
    @Test
    fun `encrypt it 2 `(){
        val s:String = "chillout"
        assertEquals("clu hlt io", Encryption(s).run(), "not encripted")
    }
    @Test
    fun `encrypt it 3 `() {
        val s: String = "haveaniceday"
        assertEquals("hae and via ecy", Encryption(s).run(), "not encripted")
    }
}