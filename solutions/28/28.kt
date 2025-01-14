class Solution {
    val charTable = mutableMapOf<Char, Int>()

    fun initCharTable(needle: String) {
        for (i in (needle.length - 2) downTo 0) {
            val char = needle[i]
            if (charTable[char] == null) {
                charTable[char] = needle.length - 1 - i
            }
        }
        val lastChar = needle[needle.length - 1]
        if (charTable[lastChar] == null)
            charTable[lastChar] = needle.length
    }
    
    fun strStr(haystack: String, needle: String): Int {
        if (needle.length == 0) return 0
        if (haystack.length < needle.length) return -1
        
        initCharTable(needle)

        var i = needle.length - 1

        while (i <= haystack.length - 1) {
            var found = true
            for (j in 0..needle.length - 1) {
                if (haystack[i - j] != needle[needle.length - 1 - j]) {
                    found = false
                    i += (charTable[haystack[i] ?: '#'] ?: needle.length)
                    break
                }
            }
            if (found) {
                return i - needle.length + 1
            }
        }

        return -1
    }
}