fun canJump(nums: IntArray): Boolean {
    if (nums.size < 2) return true
    var target = nums.size - 1
    for (i in nums.size - 2 downTo 0) {
        if (nums[i] + i >= target) target = i
    }
    return target == 0
}