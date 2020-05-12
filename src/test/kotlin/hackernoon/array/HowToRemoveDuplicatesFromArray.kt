package hackernoon.array

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

// https://javarevisited.blogspot.com/2014/01/how-to-remove-duplicates-from-array-java-without-collection-API.html?source=post_page---------------------------{^i
class HowToRemoveDuplicatesFromArrayTest {
    fun removeDuplicatesFromArray( input: Array<Int>): Array<Int>{

        var noDupArray = arrayListOf<Int>()
        for( i in input){
            if(!noDupArray.contains(i)){
                noDupArray.add(i)
            }
        }
        var result = arrayOf<Int>()
        return noDupArray.toArray(result)

    }
    @Test
    fun `how to remove duplicates from array`(){
        // hashとかを使わずに、重複を削除する
        // 数字の範囲は?
        // 計算量はどのくらいに抑えなきゃいけないとかあるか?
        var input = arrayOf<Int>(3,3,5,1,4,3,2,1,8,9)
        var expected = arrayOf<Int>(3,5,1,4,2,8,9)
        assertArrayEquals(expected, removeDuplicatesFromArray(input))
    }
}
