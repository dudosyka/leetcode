class Solution {
    var answ = 0
    
    fun countArrangement(n: Int): Int {
        if (n == 0) return answ
        val used = mutableSetOf<Int>()
        count(1, used, n)
        return answ
    }

    fun count(position: Int, used: MutableSet<Int>, n: Int) {
        if (position > n)
            answ += 1
        for (i in 1..n) {
            if (used.contains(i)) continue;
            if (i % position == 0 || position % i == 0) {
                used.add(i)
                count(position + 1, used, n)
                used.remove(i)
            }
        }
    }
}