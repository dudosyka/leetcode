class Solution {
    fun summaryRanges(nums: IntArray): List<String> {
        val answ = mutableListOf<String>();

        if (nums.size == 0)
            return answ;
        
        var start = nums[0];

        for (i in 1..(nums.size - 1)) {
            if ((nums[i] - nums[i - 1]).absoluteValue != 1) {
                if (start == nums[i - 1]) {
                    answ += "${nums[i - 1]}"
                } else {
                    answ += "${start}->${nums[i - 1]}"
                }
                start = nums[i];
            }
        }

        if (start == nums[nums.size - 1]) {
            answ += "$start"
        } else {
            answ += "${start}->${nums[nums.size - 1]}"
        }

        return answ;
    }
}