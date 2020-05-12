package hackernoon.array

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

//2.How do you find the duplicate number on a given integer array?
//solution: https://javarevisited.blogspot.com/2014/01/how-to-remove-duplicates-from-array-java-without-collection-API.html?source=post_page---------------------------
class FindDuplicateNumberTest {
    // 方法1
        /*
         1. 配列Aの一番左から、数字を取り出す(shift)
         2. 配列Aの現在の左からN番目の要素(最初はNは1)を1. で取得した数字と同じか比較
         3.    同じ場合
         4.       その数字を配列から削除
         5.       その数字を重複があった数値として配列Rに記録する
         6.    違う数字の場合
         7.          N+1をNとして2.の手順にもどる。
         8. 2-7の手順を一番右の数字にたいしてまでおこなったら1.に戻る
         9. 1-8の手順を配列から数字がなくなるまで繰り返す。
         10. 最後に配列Rを返す
         */
        // 方法2
        /*
        1. 配列Aの一番左から数字を取り出す
        2. 配列Bに取り出した数字がキーになっているものがなければ数字をキーとして設定し1を設定する
        3. 配列Bに取り出した数字がキーになっているものがあれば値を+1する
        6. 1-3を配列Aがからになるまで繰り返す
        7. 配列Bを返す
         */
        // 方法3
        /*
        1. 配列Aをソートする
        2. 配列Aの一番左から数字を取り出す(shift)
        3. 前に取り出した数字があれば、その数字を比較する。
        4. 前に取り出した数字と一致すれば配列Bにその値を追加する。すでにその値があれば何もしない
        5. 2-4を配列Aがからになるまで繰り返す
        6. 配列Bを返す
         */
        // 方法4
    fun findDuplicateNumberFromIntegerArray(arr:ArrayList<Int>):ArrayList<Int>{
        arr.sort();
        var previous : Int? = null;
        var duplicates = arrayListOf<Int>();
        for(i in arr){
            if(previous === i && duplicates.lastOrNull() !== i){
//            if(previous === i ){
                duplicates.add(i)
            }
            previous = i

        }
        return duplicates
    }
    @Test
    fun `find duplicate`(){
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
