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
    val ranks = arrayListOf<Int>()
    for(aliceScore in alice){
        var rank = rankHolder.getRank(aliceScore);
        ranks.add(rank);
    }
    val array = Array(ranks.size){0}
    ranks.toArray(array)
    return array
}

/**
 * @params scores 現在のスコアのリスト。点数降順
 */
class RankHolder(scores: Array<Int>){
//    var map: MutableMap<Int,Int>
    var scoreSize: Int = 0
    var scoreIndex: Int = 0
    var previousScore: Int = -1
    var currentRank: Int = 1

    init{
        scoreSize = scores.size
    }
    fun getRank( score:Int ):Int{

        // スコアリストの上から順に処理を実行する
        // すでにチェック済みのスコアは飛ばす
        // そのために現在のindexを保存しておく
        for(i in 0 until scoreSize){
            // check if i is the same as previous i value, if so, skip
            // check if score is larger or equal to (i)
            // if large or equal, then return current rank
            // if not, increment current rank
        }



//        run loop@{
//            map.forEach{
//                if(it.value > score){
//                    rank = it.key + 1
//                    return@forEach
//                }
//                return@loop
//            }
//        }
//        return rank
        return 1
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
