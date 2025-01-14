class Solution {
    val regex = Regex("""(\d{2})\:(\d{2})""")
    
    fun findMinDifference(timePoints: List<String>): Int {
        val minutes = IntArray(24 * 60) { Int.MAX_VALUE }

        for (time in timePoints) {
            val match = regex.find(time)!!.groups
            val m = match[1]!!.value.toInt() * 60 + match[2]!!.value.toInt()
            if (minutes[m] != Int.MAX_VALUE) return 0
            minutes[m] = m
        }

        var minimum = Int.MAX_VALUE
        var maximum = Int.MIN_VALUE
        var start = Int.MAX_VALUE
        var answ = Int.MAX_VALUE

        for (time in minutes) {
            if (time != Int.MAX_VALUE && time > maximum) maximum = time
            if (time < minimum) minimum = time

            if (start == Int.MAX_VALUE) {
                if (time == Int.MAX_VALUE) continue
                start = time
                continue
            }

            if (time == Int.MAX_VALUE) continue

            answ = min(time - start, answ)
            start = time
        }

        return min(answ, 24 * 60 - maximum + minimum)
    }
}