class Solution {
    fun longestOnes(nums: IntArray, k: Int): Int {
        var result = 0

        var buffers = IntArray(k) { -1 }
        var buffersSum = 0
        var kIndex = -1
        var count = 0

        for (num in nums) {
            if (num == 1) {
                count += 1
                continue
            }

            if (result < buffersSum + count) {
                result = buffersSum + count
            }

            if (kIndex < (k - 1)) {
                kIndex += 1
            } else {
                kIndex = 0
            }

            if (k > 0) {
                if (buffers[kIndex] >= 0) {
                    buffersSum -= (buffers[kIndex] + 1)
                }
                buffers[kIndex] = count
                buffersSum += (count + 1)
            }

            count = 0
        }

        if (result < buffersSum + count) {
            result = buffersSum + count
        }

        return result
    }
}