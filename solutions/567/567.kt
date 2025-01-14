class Solution {
    val charTable = mutableMapOf<Char, Int>()

    fun initCharTable(s1: String) {
        for (char in s1) {
            if (charTable[char] == null) {
                charTable[char] = 0
            }
            charTable[char] = charTable[char]!! + 1
        }
    }


    fun checkInclusion(s1: String, s2: String): Boolean {
        initCharTable(s1)

        var i = s1.length - 1
        while (i < s2.length) {
            var found = true
            val tempTable = mutableMapOf<Char, Int>()
            for (j in 0..<s1.length) {
                val char = s2[i - j]
                val entry = charTable[char]
                if (entry == null) {
                    found = false
                    i += (s1.length - j)
                    break
                } 
                else {
                    if (tempTable[char] == null)
                        tempTable[char] = 0
                    
                    tempTable[char] = tempTable[char]!! + 1

                    if (tempTable[char]!! > entry) {
                        found = false
                        i += (s1.length - j)
                        break
                    }
                }
            }
            if (found)
                return true
        }

        return false
    }
}