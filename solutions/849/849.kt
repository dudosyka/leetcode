import kotlin.math.floor

class Solution {
    fun distance(a: Int, b: Int): Int {
        if (a == -1)
            return b

        val diff: Double = (b - a).toDouble()

        return floor(diff / 2).toInt()
    }

    fun maxDistToClosest(seats: IntArray): Int {
        var maximum: Int? = null
        var curStart: Int? = null
        for (i in seats.indices) {
            val seat = seats[i]

            if (seat == 0) {
                if (curStart == null)
                    curStart = i - 1
                continue;
            }

            if (curStart == null) continue;

            val dist = distance(curStart!!, i)

            if (maximum == null || maximum < dist)
                maximum = dist
            
            curStart = null
        }

        if (curStart != null) {
            val size = seats.size - curStart - 1
            if (maximum == null || size > maximum)
                return size
        }

        return maximum ?: -1
    }
}