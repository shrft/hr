package hackernoon.array

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.collections.ArrayList
import kotlin.collections.HashSet
import kotlin.math.max
import kotlin.math.min

//https://javarevisited.blogspot.com/2014/08/how-to-find-all-pairs-in-array-of-integers-whose-sum-equal-given-number-java.html?source=post_page---------------------------
class FindPairsOfIntegerArrayWhoseSumIsEqualToGivenNumber {
    fun findPairs(array: ArrayList<Int>, target: Int):ArrayList<Pair<Int, Int>>{
        var result = arrayListOf<Pair<Int, Int>>()
        var size = array.count()
        for( i in 0..size-2 ){
            for(j in i+1..size-1){
                var sum = array[j]+array[i]
                if(sum === target){
                    val first = min(array[i], array[j])
                    val second = max(array[i],array[j])
                    result.add(Pair(first,second))
                }
            }
        }
        return result
    }
    @Test
    fun `How do you find all pairs of an integer array whose sum is equal to a given number`(){
        var array  = arrayListOf<Int>(2, 6, 3, 9, 11);
        var target = 9;
        var actual = findPairs(array, target)
        var expected = arrayListOf<Pair<Int,Int>>(Pair(3,6))
        assertEquals(expected, actual);

        array  = arrayListOf<Int>(2, 6, 3, 3,9, 11);
        target = 9;
        actual = findPairs(array, target)
        expected = arrayListOf<Pair<Int,Int>>()
        expected.add(Pair(3,6));
        expected.add(Pair(3,6));
        assertEquals(expected, actual);

        array  = arrayListOf<Int>(2, 6, 3, 3,9,5,11,4);
        target = 9;
        actual = findPairs(array, target)
        expected = arrayListOf<Pair<Int,Int>>()
        expected.add(Pair(3,6));
        expected.add(Pair(3,6));
        expected.add(Pair(4,5));
        assertEquals(expected, actual);

    }
    fun findPairsWithHashTable(array: ArrayList<Int>, target: Int):ArrayList<Pair<Int, Int>>{
        var result = arrayListOf<Pair<Int, Int>>()

        // 1. ハッシュテーブルに全ての値をセット
        var numbers = HashSet<Int>();
//        for (elm in array){
//            numbers.add(elm)
//        }
        // 2. 配列をループして、target - 配列[i]の値が、hashsetにあるかチェック
        for ( value in array){
            val targetPairNumber = target - value;
            // 3. ある場合は、ペアとして登録する
            if(!numbers.contains(targetPairNumber)){
                numbers.add(value)
            }else{
                 val first = min(value, targetPairNumber)
                val second = max(value,targetPairNumber)
                result.add(Pair(first,second))

            }
        }
        return result

    }

    // 1. hashsetを使ったパターンを書く
    @Test
    fun `How do you find all pairs of an integer array whose sum is equal to a given number with hash table`(){
        var array  = arrayListOf<Int>(2, 6, 3, 9, 11);
        var target = 9;
        var actual = findPairsWithHashTable(array, target)
        var expected = arrayListOf<Pair<Int,Int>>(Pair(3,6))
        assertEquals(expected, actual);

        array  = arrayListOf<Int>(2, 6, 3, 3,9, 11);
        target = 9;
        actual = findPairsWithHashTable(array, target)
        expected = arrayListOf<Pair<Int,Int>>()
        expected.add(Pair(3,6));
        expected.add(Pair(3,6));
        assertEquals(expected, actual);

        array  = arrayListOf<Int>(2, 6, 3, 3,9,5,11,4);
        target = 9;
        actual = findPairsWithHashTable(array, target)
        expected = arrayListOf<Pair<Int,Int>>()
        expected.add(Pair(3,6));
        expected.add(Pair(3,6));
        expected.add(Pair(4,5));
        assertEquals(expected, actual);
    }
    fun findPairsWithQuickSort(array: ArrayList<Int>, target: Int):ArrayList<Pair<Int, Int>>{
        array.sort()
        var leftPointer = 0;
        var rightPointer = array.count() - 1;
        var pairs = arrayListOf<Pair<Int,Int>>();
        var i = leftPointer;

        for(i in 0..array.count()){
            if(leftPointer >= rightPointer) break;
            var sum = array[leftPointer] + array[rightPointer]

            if(sum === target){
                pairs.add( Pair(array[leftPointer],array[rightPointer]))
                leftPointer++
                rightPointer--
            }else if(sum > target){
                rightPointer--
            }else{
                leftPointer++
            }
        }
        return pairs

    }
    // 2. 配列ソート-> 右と左の両方からチェックしていく方法を学ぶ
    @Test
    fun `How do you find all pairs of an integer array whose sum is equal to a given number with quick sort`(){
        var array  = arrayListOf<Int>(2, 6, 3, 9, 11);
        var target = 9;
        var actual = findPairsWithQuickSort(array, target)
        var expected = arrayListOf<Pair<Int,Int>>(Pair(3,6))
        assertEquals(expected, actual);

        array  = arrayListOf<Int>(2, 6, 3, 3,9, 11);
        target = 9;
        actual = findPairsWithHashTable(array, target)
        expected = arrayListOf<Pair<Int,Int>>()
        expected.add(Pair(3,6));
        expected.add(Pair(3,6));
        assertEquals(expected, actual);
//
        array  = arrayListOf<Int>(2, 6, 3, 3,9,5,11,4);
        target = 9;
        actual = findPairsWithHashTable(array, target)
        expected = arrayListOf<Pair<Int,Int>>()
        expected.add(Pair(3,6));
        expected.add(Pair(3,6));
        expected.add(Pair(4,5));
        assertEquals(expected, actual);
    }
}