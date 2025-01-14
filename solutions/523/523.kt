class Solution {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        val prefix = mutableMapOf<Int, Int>()
        var curSum = 0
        var answ = 0
        var i = 0
        for (n in nums) {
            curSum += n
            val diff = curSum % k
            val diff_ = if (diff >= 0) diff - k else diff + k 

            if (diff == 0) {
                if (i > 0) return true
                prefix[diff] = i
            }

            if (prefix[diff] != null) {
                if (i - prefix[diff]!! > 1) return true
            } else {
                prefix[diff] = i
            }

            if (prefix[diff_] != null) {
                if (i - prefix[diff_]!! > 1) return true
            }

            i++
        }
        return false
    }
}