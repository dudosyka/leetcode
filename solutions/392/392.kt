class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        var sIndex = 0
        for (char in t) {
            if (sIndex == s.length)
                return true
            val sChar = s[sIndex]
            if (sChar == char) {
                sIndex += 1
            }
        }

        if (s.length == 0)
            return true

        return sIndex == s.length
    }
}