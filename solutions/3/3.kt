class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var longest = 0

        if (s.length == 0)
            return longest

        var start = 0
        val current = mutableMapOf<Char, Int>()

        for (i in 0..(s.length-1)) {
            val char = s[i]
            val oldCharPos = current[char]

            if (oldCharPos != null) {
                for (j in start..oldCharPos) {
                    current.remove(s[j])
                }
                start = (oldCharPos + 1)
            }
            current[char] = i
            longest = max(current.size, longest)
        }

        return longest
    }
}