class Solution {
    fun findLUSlength(a: String, b: String): Int {
        if (a == b) return -1
        return max(a.length, b.length)
    }
}