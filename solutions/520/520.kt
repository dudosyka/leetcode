class Solution {
    fun detectCapitalUse(word: String): Boolean {
        if (word[0].isUpperCase()) {
            if (word.length == 1) return true
            if (word[1].isUpperCase()) {
                var i = 1
                while (i + 1 < word.length && word[++i].isUpperCase()) {}
                return (i == word.length - 1 && word[i].isUpperCase)
            } else {
                return word.slice(1..(word.length - 1)).toLowerCase() == word.slice(1..(word.length - 1))
            }
        } else {
            return word.toLowerCase() == word
        }
    }
}