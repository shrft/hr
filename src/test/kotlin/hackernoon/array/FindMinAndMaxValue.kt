package hackernoon.array

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

// How do you find the largest and smallest number in an unsorted integer array?
// solution: https://www.java67.com/2014/02/how-to-find-largest-and-smallest-number-array-in-java.html?source=post_page---------------------------
class FindMinAndMaxValueTest {


    fun findMinAndMaxValue(numbers : ArrayList<Int>): Pair<Int,Int>{
        var max = numbers[0]
        var min = numbers[0]
        numbers.removeAt(0);
        for(n in numbers){
            if(max < n){
                max = n
            }
            if(min > n){
                min = n
            }
        }
        return Pair(min,max)
    }
    @Test
    fun `find min and max values from unsorted integer array`() {

        var array = arrayListOf<Int>(3,2,4,5);
        var actual = findMinAndMaxValue(array)
        var expected  = Pair(2,5)
        assertEquals(actual, expected)

        array = arrayListOf<Int>(1,1,1,1,1);
        actual = findMinAndMaxValue(array)
        expected  = Pair(1,1)
        assertEquals(actual, expected)

    }

}