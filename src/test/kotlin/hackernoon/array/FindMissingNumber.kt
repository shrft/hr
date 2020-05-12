package hackernoon.array

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

// https://javarevisited.blogspot.com/2014/11/how-to-find-missing-number-on-integer-array-java.html?source=post_page

class FindMissingNumberTest {


    fun getMissingNumber(numbers: ArrayList<Int>): ArrayList<Int> {
        var previous = 0;
        var missingNumbers = arrayListOf<Int>()
        for (n in numbers){
            if(n !== previous+1){
                missingNumbers.add(n-1)
            }
            previous = n
        }
        return missingNumbers;
    }
    @Test
    fun `How do you find the missing number in a given integer array of 1 to 10`() {
        var numbers = arrayListOf(1,2,3,4,6,7,8,9,10)
        var num = getMissingNumber(numbers);
        var expected1 = arrayListOf(5)
        assertEquals(expected1, num)

        var numbers2 = arrayListOf(1,2,4,5,6,7,8,9,10)
        var num2 = getMissingNumber(numbers2);
        var expected2 = arrayListOf(3)
        assertEquals(expected2, num2)


        // かけている数字が2つ以上ある場合
        var numbers3 = arrayListOf(1,2,4,5,6,8,9,10)
        var num3 = getMissingNumber(numbers3);
        var expected3 = arrayListOf(3,7)
        assertEquals(expected3, num3)
    }
    fun getMissingNumberWithBitset(numbers: ArrayList<Int>, lastNum: Int): ArrayList<Int> {

        var bits = BitSet(lastNum);

        for(num in numbers){
            bits.set(num - 1 )
        }

        var missingNumbers = arrayListOf<Int>()
        var i = 0;
        val size = lastNum
        while(true){
            i = bits.nextClearBit(i)
            if(i >= size){
                break
            }
            missingNumbers.add(i + 1)
            i++
        }
        return missingNumbers
    }
    @Test
    fun `bitset solution How do you find the missing number in a given integer array of 1 to 10`(){
        var numbers = arrayListOf(1,2,3,4,6,7,8,9,10)
        var num = getMissingNumberWithBitset(numbers, 10);
        var expected1 = arrayListOf(5)
        assertEquals(expected1, num)

    }
    @Test
    fun `bitset solution How do you find the missing numbers in a given integer array of 1 to 10`(){
        var numbers = arrayListOf(1,3,4,6,7,10)
        var num = getMissingNumberWithBitset(numbers, 10);
        var expected1 = arrayListOf(2,5,8,9)
        assertEquals(expected1, num)

    }
    @Test
    fun `bitset solution How do you find the missing numbers in a given integer array of 1 to 10 ver2`(){
        var numbers = arrayListOf(1,3,4,6,7,8)
        var num = getMissingNumberWithBitset(numbers, 10);
        var expected1 = arrayListOf(2,5,9,10)
        assertEquals(expected1, num)

    }
}