class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val diffMap = mutableMapOf<Int, Int>();
        
        nums.forEachIndexed {
            index, it ->
                if (diffMap[it] != null) {
                    return@twoSum intArrayOf(diffMap[it]!!, index)
                }
                diffMap[target - it] = index 
        }

        return intArrayOf();
    }
}