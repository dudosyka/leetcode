class Solution {
    fun addCompare(compareMap: MutableMap<Int, MutableMap<Int, Int>>, key: Int, arrIndex: Int): Boolean {
        val second = if (arrIndex == 0) 1 else 0
        val selected = compareMap[key]

        if (selected != null) {
            val prev = (selected[arrIndex]!! - selected[second]!!).absoluteValue
            selected[arrIndex] = selected[arrIndex]!! + 1
            return prev > (selected[arrIndex]!! - selected[second]!!).absoluteValue
        } else {
            compareMap[key] = mutableMapOf(arrIndex to 1, second to 0)
            return false
        }
    }

    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val resultList = mutableListOf<Int>()
        val compareMap: MutableMap<Int, MutableMap<Int, Int>> = mutableMapOf();

        for (i in 0..(max(nums1.size, nums2.size) - 1)) {
            if (i <= nums1.size - 1) {
                if (addCompare(compareMap, nums1[i], 0)) {
                    resultList.add(nums1[i])
                }
            }

            if (i <= nums2.size - 1) {
                if (addCompare(compareMap, nums2[i], 1)) {
                    resultList.add(nums2[i])
                }
            }
        }
        
        
        return resultList.toIntArray()
    }

    fun intersect(nums1: IntArray, nums2: IntArray) = nums2.filter { 
        val i = nums1.indexOf(it)
        if (i >= 0) nums1[i] = -1
        i >= 0
    }
}