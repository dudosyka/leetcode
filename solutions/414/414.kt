class MaxContainer(val size: Int) {
    val set = mutableSetOf<Int>()

    fun add(n: Int) {
        set.add(n)

        if (set.size > size) {
            set.remove(set.min())
        }
    }

    fun getResult(): Int {
        return if (set.size < size) set.max() else set.min()
    }
}

class Solution {
    fun thirdMax(nums: IntArray): Int {
        val sorted: SortedSet<Int> = TreeSet()

        for (num in nums) {
            sorted.add(num)
        }
        
        return sorted.elementAtOrElse(sorted.size - 3) { sorted.last() }
    }
}