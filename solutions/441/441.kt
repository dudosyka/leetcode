class Solution {
    fun arrangeCoins(n: Int): Int {
        var lvl = 0
        var curN = n
        while (curN > 0) {
            lvl += 1
            curN -= lvl
        }

        return if (curN < 0) lvl - 1 else lvl
    }
}