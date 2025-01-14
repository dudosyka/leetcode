class Solution {
    fun getPalindrome(s: String, startLeft: Int, startRight: Int): String {
        var left = startLeft
        var right = startRight
        while (s[left] == s[right]) {
            if (left > 0 && right < s.length - 1) {
                left -= 1
                right += 1
            } else {
                break
            }
        }

        if (s[left] == s[right])
            return s.slice(left..right)
        else    
            return s.slice((left + 1)..(right - 1))
    }

    fun longestPalindrome(s: String): String {
        if (s.length == 1)
            return s

        var i = 1
        var max = ""

        while (i <= s.length - 1) {
            //Check for 2 symbols palindrome
            if (s[i - 1] == s[i]) {
                val found = getPalindrome(s, i - 1, i)
                if (found.length > max.length)
                    max = found
            }

            if (i + 1 <= (s.length - 1) && s[i - 1] == s[i + 1]) {
                val found = getPalindrome(s, i - 1, i + 1)
                if (found.length > max.length)
                    max = found
            }

            i += 1
        }

        if (s.length == 2)
            if (s[0] == s[1])
                return s
            else
                return s.slice(0..0)
        
        if (s.length > 2 && max.length == 0)
            return s.slice(0..0)

        return max
    }
}