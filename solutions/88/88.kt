class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        if (nums1.size == 0)
            return;

        var insertPoint = (nums1.size - 1)
        var nums1Point = m - 1
        
        for (num2Point in (n - 1) downTo 0) {
            val num2 = nums2[num2Point]
            if (nums1Point >= 0) {
                var num1 = nums1[nums1Point]
                while (num1 > num2) {
                    nums1[insertPoint] = num1
                    insertPoint -= 1
                    nums1Point -= 1
                    if (nums1Point < 0)
                        break;
                    num1 = nums1[nums1Point]
                }
            }
            nums1[insertPoint] = num2
            insertPoint -= 1
        }
    }
}