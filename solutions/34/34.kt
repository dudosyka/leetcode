class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        var lowerBound = 0
        var upperBound = nums.size - 1
        while (lowerBound <= upperBound) {
            val mid = lowerBound + (upperBound - lowerBound) / 2
            if (nums[mid] == target) {
                var start = mid
                var end = mid
                while (start > 0 && nums[start - 1] == target) {
                    start -= 1
                }
                while (end < nums.size - 1 && nums[end + 1] == target) {
                    end += 1
                }
                return intArrayOf(start, end)
            }
            if (target > nums[mid]) {
                lowerBound = mid + 1
            } else {
                upperBound = mid - 1 
            }
        }

        return intArrayOf(-1, -1)
    }
}