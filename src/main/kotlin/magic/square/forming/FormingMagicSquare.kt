package magic.square.forming

import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.sqrt
import kotlin.system.exitProcess
import kotlin.collections.ArrayList as ArrayList

//時間切れになってしまう。
fun formingMagicSquare(s: Array<Array<Int>>): Int {
    return FormingMagicSquare(s).run()
}
class FormingMagicSquare(private val square:Array<Array<Int>>){
    private val magicSquares = ArrayList<Square>()
    init{
        prepareMagicSquares()
    }
    fun run():Int{
        val origin = Square(square)

        if(origin.isMagicSquare()) return 0

        var costs = ArrayList<Int>()
        val calc = Calc()
        for(m in magicSquares){
            var cost = calc.cost(m,origin)
//            if(cost == 12){
//                println(m)
//            }
            costs.add(cost)
        }
//        println(costs)
        return costs.min()?:0
    }
    fun prepareMagicSquares(){
        val numbers = arrayListOf<Int>(1,2,3,4,5,6,7,8,9)
        var combinations:ArrayList<Array<Int>> = Combination(numbers).all()
        for(number in combinations){
            val square = squareFromNumber(number)

            if(square.isMagicSquare()){
                magicSquares.add(square)
            }
        }
    }
}
class Calc{
    fun cost(a: Square, b: Square): Int {
        var costs  = ArrayList<Int>()
        for(i in 0..2){
            for(j in 0..2){
                val aVal = a.map[i][j]
                val bVal = b.map[i][j]
                if(aVal == bVal){
                    continue
                }
                costs.add(abs(aVal - bVal))
            }
        }
        return costs.sum()
    }
}
class Combination(private val numbers: ArrayList<Int>){
    private val patterns = arrayListOf<Array<Int>>()
    fun all():ArrayList<Array<Int>>{
        val generated = arrayListOf<Int>()
        get(generated, numbers)
        return patterns
    }
    fun get(generated:ArrayList<Int>, remain:ArrayList<Int>){
        var generated = generated
        var remain = remain
        if(remain.isEmpty()){
            patterns.add(generated.toTypedArray())
            return
        }
        for ((index, n) in remain.withIndex()){
            val newStr = arrayListOf<Int>()
            newStr.addAll(generated)
            newStr.add(n)
            //todo: ここでmagic squareの可能性がない場合は処理を中断する
            val newRemain = arrayListOf<Int>()
            newRemain.addAll(remain)
            newRemain.removeAt(index)
            get(newStr, newRemain)
        }
    }
}
fun squareFromNumber(number:Array<Int>): Square {
    val len = ceil(sqrt(number.size.toFloat())).toInt()
    val map = Array(len){
                i->Array(len){
                j->
                val ind = i * len + j
                if(number.size > ind){
                    number[ind]
                }else{
                    -1
                }
            }}
    return Square(map);

}
class Square(var map:Array<Array<Int>>){
    fun fromSquare(number:Array<Int>){

    }
    override fun toString():String{
        var str = ""
       for(row in this.map){
           for(col in row){
               str += col.toString()
           }
       }
        return str
    }
    fun isEqualTo(square: Square):Boolean{
          return this.map.contentDeepEquals(square.map)
    }
    fun isMagicSquare():Boolean{
        val baseNum = map[0].sum()
        var colSums = intArrayOf(0,0,0)
        for((index,row) in this.map.withIndex()){

            // 横一列すべてが基準値と同じかチェック
            if( row.sum() != baseNum ) return false;
            for( (ind,col) in row.withIndex() ){
                colSums[ind] += col.toString().toInt();
            }
        }
        for (colSum in colSums){
            // 縦一列すべてが基準値と同じかチェック
            if(colSum != baseNum) return false
        }

        // ななめすべてが基準値と同じかチェック
//        var d1 = this.numbers[0].toString().toInt() + this.numbers[4].toString().toInt() + this.numbers[8].toString().toInt()
        var d1 = this.map[0][0] + this.map[1][1] + this.map[2][2]
        if(d1 != baseNum) return false;
//        var d2 = this.numbers[2].toString().toInt() + this.numbers[4].toString().toInt() + this.numbers[6].toString().toInt()
        var d2 = this.map[2][0] + this.map[1][1] + this.map[0][2]
        if(d2 != baseNum) return false;

        return true
    }
}
