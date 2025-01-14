class Solution {
    fun findMaxLength(nums: IntArray): Int {
        val prefix = mutableMapOf<Int, Int>()
        var curSum = 0
        var answ = 0
        var i = 0

        if (nums.size < 2) return 0

        for (i in nums.indices) {
            val num = nums[i]
            curSum += num
            val zeros = (i - curSum) + 1
            val diff = curSum - zeros
            
            if (diff == 0) {
                answ = max(i + 1, answ)
                continue;
            }

            if (prefix.contains(diff)) {
                answ = max(i - prefix[diff]!!, answ)
            } else {
                prefix[diff] = i
            }
        }

        return answ
    }
}