class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        var insertPos = 0
        for (it in nums) {
            if(it != 0) {
                nums[insertPos] = it
                insertPos++
            }
        }
        
        for(i in insertPos..nums.size-1) {
            nums[i] = 0
        }
    }
}
