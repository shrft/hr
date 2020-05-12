package hackernoon.array

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

// How do you find duplicate numbers in an array if it contains multiple duplicates?
// solution: https://javarevisited.blogspot.com/2014/03/3-ways-to-find-first-non-repeated-character-String-programming-problem.html?source=post_page---------------------------
class FindDuplicateNumbersInAnArrayWithMultipleDuplicatesTest {
    fun findDuplicateNumberFromIntegerArray(arr:ArrayList<Int>):ArrayList<Int>{
        val duplicates = arrayListOf<Int>()
        arr.sort()
        var lastIndex = arr.count()-1
        var offset = 0
        for(  i in 0..lastIndex){
            var pos = i + offset
            if(pos+1 > lastIndex){
                break
            }

            if(duplicates.contains(arr[i])){
                continue
            }

            if(arr[pos] === arr[pos+1]){
                duplicates.add(arr[pos]);
                offset++
                continue
            }
        }
        return duplicates
    }
    // 処理毎の計算量を考えてみる
    @Test
    fun `how do you find duplicate numbers in an array if it contains multiple duplicates?`(){

        var arr = arrayListOf<Int>(1,2,3,3,4,5);

        var actual = findDuplicateNumberFromIntegerArray(arr);
        var expected = arrayListOf<Int>(3);
        assertEquals(expected, actual);

        arr = arrayListOf<Int>(1,2,3,4,4,5);
        actual = findDuplicateNumberFromIntegerArray(arr);
        expected = arrayListOf<Int>(4);
        assertEquals(expected, actual);

        arr = arrayListOf<Int>(8,6,7,3,2,1,3,4,3,3,2);
        actual = findDuplicateNumberFromIntegerArray(arr);
        expected = arrayListOf<Int>(2,3);
        assertEquals(expected, actual);

    }
}