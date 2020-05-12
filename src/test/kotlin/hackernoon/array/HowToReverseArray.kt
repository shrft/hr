package hackernoon.array

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

// https://javarevisited.blogspot.com/2014/01/how-to-remove-duplicates-from-array-java-without-collection-API.html?source=post_page---------------------------{^i
class HowToReverseArray {
    // reverse int array

    fun reverseIntArray(input:Array<Int>): Array<Int>{
        val lastIndex = input.size -1
        val result = Array<Int>(input.size){0}
        for(i in 0..lastIndex){
            result[lastIndex-i] = input[i]
        }
        // 数を数える
        // 大きい数から新しい配列に入れていく
        return result
    }
    @Test
    fun reverseIntArrayTest(){
        val input = arrayOf(9,8,7,6,5,4,3,2,1,0)
        val expected = arrayOf(0,1,2,3,4,5,6,7,8,9)

        val actual = reverseIntArray(input)
        assertArrayEquals(expected,actual)
    }
}