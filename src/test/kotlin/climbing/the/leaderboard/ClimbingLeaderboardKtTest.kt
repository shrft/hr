
package magic.square.forming

import climbing.the.leaderboard.RankHolder
import climbing.the.leaderboard.climbingLeaderboard
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class ClimbingLeaderboardKtTest {
    @Test
    fun `get rank3`(){
        var scores = arrayOf(100, 90, 90, 80, 75, 60)
        var holder = RankHolder(scores)

        // 一番大きい
        assertEquals(1, holder.getRank(110))
        // 一番大きい数字と同じ
        assertEquals(1, holder.getRank(100))
        // ２番目
        assertEquals(2, holder.getRank(95))
        // 2番目に大きい数字と同じ
        assertEquals(2, holder.getRank(90))
        // 一番小さい
        assertEquals(6, holder.getRank(55))
        // 一番小さい数字と同じ
        assertEquals(5, holder.getRank(60))
    }

}
