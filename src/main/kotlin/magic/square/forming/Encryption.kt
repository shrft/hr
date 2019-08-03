package magic.square.forming

import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.sqrt
import java.util.Arrays

class Encryption(input: String){
    var encrypted: String? = null
    var before: String = input

    fun run():String{

        var str = removeSpace(before)
        var len = getRoot(str)
        var row = floor(len).toInt()
        var col = ceil(len).toInt()

        if(row * col < str.length){
            row = col
        }

        var encrypted = ""

        // col x rowの配列を作成
        // 配列に文字を埋めていく
        // ループして縦に出力する

        var map = Array(row){
            i->Array(col){
                j->
                    var pos = i * col + j
                    if(pos < str.length){
                        str[ pos ]
                    }else{
                        ""
                    }
            }
        }

        val x = col - 1
        val y = row - 1
        for(i in 0..x ){
            for (j in 0..y){
                if(j == 0 && i != 0 ) encrypted += " "
                encrypted += map[j][i]
            }
        }

        return encrypted
    }
    private fun removeSpace(str: String):String{
        return str.replace(" ", "");
    }
    private fun getRoot(str: String): Double{
        return sqrt(str.length.toDouble())
    }
}

