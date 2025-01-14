class Solution {
    fun longestSubarray(nums: IntArray): Int {
        var maxLength = 0
        var count = 0
        var buffer = 0

        for (num in nums) {
            if (num == 1) {
                count += 1
                prev = num
                continue
            } 

            if (maxLength < (count + buffer)) {
                maxLength = (count + buffer)
            }
            buffer = count
            count = 0
        }

        if (count != 0 || buffer != 0)
            if (maxLength < (count + buffer))
                maxLength = (count + buffer)
            

        if (maxLength == nums.size && maxLength != 0)
            return maxLength - 1

        return maxLength
    }
}