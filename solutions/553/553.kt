class Solution {
    fun brace(nums: IntArray, opening: Boolean): String {
        return if (nums.size > 2) {
            if (opening) "(" else ")"
        } else {
            return ""
        }
    }

    fun optimalDivision(nums: IntArray): String {
        return if (nums.size > 1) "${nums[0]}/" + brace(nums, true) + nums.slice(1..(nums.size - 1)).joinToString("/") + brace(nums, false) else nums[0].toString()
    }
}