class Solution {
    fun missingNumber(nums: IntArray): Int {
        val n: Float = (nums.size + 1).toFloat()
        val sum: Float = ((n - 1) / 2) * n
        var actualSum = 0
        for (i in 0..(nums.size - 1)) {
            actualSum += nums[i]
        }

        return sum.toInt() - actualSum
    }
}