class Solution {
    fun subarraysDivByK(nums: IntArray, k: Int): Int {
        var currSum = 0
        var res = 0

        val map = mutableMapOf<Int, Int>(0 to 1)

        for (num in nums) {
            currSum += num
            val diff = currSum % k
            val diff_ = if (diff >= 0) diff - k else diff + k 

            if (diff == 0) {
                res += 1
            }

            if (map.contains(diff_) && diff_ != k) {
                res = res + map[diff_]!!
            }

            if (map.contains(diff) != null) {
                res = res + map[diff]!!
                map[diff] = map[diff]!! + 1
            } else {
                map[diff] = 1
            }
        }

        return res
    }
}