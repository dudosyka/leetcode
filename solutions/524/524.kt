class Solution {
    fun findLongestWord(s: String, dictionary: List<String>): String {
        var diff = IntArray(dictionary.size) { 0 }
        var max = -1
        var i = 0

        while (i < s.length) {
            var j = 0
            while (j < dictionary.size) {
                val word = dictionary[j]
                if (diff[j] == word.length) {
                    j++
                    continue
                }

                if (word[diff[j]] == s[i]) {
                    diff[j] += 1
                    if (diff[j] == word.length) {
                        if (max == -1 || dictionary[max].length < word.length) max = j
                        else {
                            if (dictionary[max].length == word.length && word < dictionary[max])
                                max = j
                        }
                    }
                }
                j++
            }
            i++
        }

        return if (max == -1) "" else dictionary[max]
    }
}