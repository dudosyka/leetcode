class Solution {
    fun sortedSquares(nums: IntArray): IntArray {
        if (nums.size == 0)
            return intArrayOf()
        
        val result = IntArray(nums.size)
        var position = nums.size - 1
        var leftPos = 0
        var rightPos = nums.size - 1

        var left = nums[leftPos]
        var right = nums[rightPos]
        
        
        while (position >= 0) {
            while (left.absoluteValue >= right.absoluteValue) {
                result[position] = left * left
                leftPos += 1
                position -= 1
                if (leftPos >= nums.size || position < 0)
                    break;
                left = nums[leftPos]
            }

            while (position >= 0 && right.absoluteValue > left.absoluteValue) {
                result[position] = right * right
                rightPos -= 1
                position -= 1
                if (rightPos < 0 || position < 0)
                    break;
                right = nums[rightPos]
            }
        }

        return result
    }
}