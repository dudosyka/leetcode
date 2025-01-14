class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        var currSum = 0
        var res = 0

        val map = mutableMapOf<Int,Int>()

        for(i in nums.indices){
            currSum = nums[i] + currSum
            var diff = currSum - k
           
             if (currSum == k) {
                res+=1
            }

            if (map.contains(diff)) {
                res = res + map[diff]!!
            }

            if (map.contains(currSum)) {
                map[currSum] = map[currSum]!! + 1
            } else {
                map[currSum] = 1
            }

        }

        return res   
    }
}