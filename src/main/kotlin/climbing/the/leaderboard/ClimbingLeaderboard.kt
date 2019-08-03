package climbing.the.leaderboard

import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

//https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
fun climbingLeaderboard(scores: Array<Int>, alice: Array<Int>): Array<Int> {
    val rankHolder = RankHolder(scores)
    todo@shira: ここから。aliceのランキングをプリントする?
    scoresにアリスのランキングがない場合を考慮していない

}
class RankHolder(scores: Array<Int>){
    lateinit var map: MutableMap<Int,Int>
    init{
        map = scoresToRankMap(scores);
    }
    fun getRankMap():MutableMap<Int,Int>{
        return map
    }
    fun scoresToRankMap(scores: Array<Int>):MutableMap<Int,Int>{
        var map = mutableMapOf<Int,Int>()
        var currentRank = 0;
        for(score in scores){
            if(map.containsValue(score)){
                continue;
            }
            currentRank++;
            map.put(currentRank, score)
        }
        return map
    }
    fun getRank( score:Int ):Int{
        return map.filterValues { it == score }.keys.first()
    }
}

//fun main(args: Array<String>) {
//    val scan = Scanner(System.`in`)
//
//    val scoresCount = scan.nextLine().trim().toInt()
//
//    val scores = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
//
//    val aliceCount = scan.nextLine().trim().toInt()
//
//    val alice = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
//
//    val result = climbingLeaderboard(scores, alice)
//
//    println(result.joinToString("\n"))
//}
