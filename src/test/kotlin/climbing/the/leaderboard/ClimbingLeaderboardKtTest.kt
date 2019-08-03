
package magic.square.forming

import climbing.the.leaderboard.RankHolder
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

        assertEquals(1, holder.getRank(100))
        assertEquals(2, holder.getRank(90))
        assertEquals(3, holder.getRank(80))
        assertEquals(4, holder.getRank(75))
    }
}
