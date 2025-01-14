class Solution {
    fun IntArray.first(): Int {
        return this[0]
    }

    fun IntArray.second(): Int {
        return this[1]
    }

    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.size == 0)
            return intervals

        intervals.sortBy { it[0] }
 
        val result = mutableListOf<IntArray>();
        var curStartPoint = intervals[0].first()
        var curEndPoint = intervals[0].second()

        for (i in 1..(intervals.size - 1)) {
            val int = intervals[i]

            if (curEndPoint < int.first() || curStartPoint > int.second()) {
                result += intArrayOf(curStartPoint, curEndPoint)
                curStartPoint = int.first()
                curEndPoint = int.second()
                continue;
            }

            if (curEndPoint >= int.first()) {
                if (curStartPoint >= int.first()) {
                    curStartPoint = int.first()
                }
                if (curEndPoint <= int.second()) {
                    curEndPoint = int.second()
                }
            }
        }

        result += intArrayOf(curStartPoint, curEndPoint)

        return result.toTypedArray()
    }
}