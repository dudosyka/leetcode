fun singleNonDuplicate(nums: IntArray): Int {
    var left = 0
    var right = nums.size - 1
    while (left <= right) {
        val mid = left + (right - left) / 2

        if (mid != 0 && nums[mid] == nums[mid - 1]) {
            if ((mid - left) % 2 == 0)
                right = mid - (mid % 2)
            else
                left = mid + (mid % 2)

        } else if (mid != nums.size - 1 && nums[mid] == nums[mid + 1]) {
            if ((right - mid) % 2 == 0)
                left = mid + (mid % 2)
            else
                right = mid - (mid % 2)

        } else {
            return nums[mid]
        }
    }
    return -1
}