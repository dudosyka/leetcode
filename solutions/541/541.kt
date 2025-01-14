class Solution {
    fun reverseSubstring(s: String, start: Int, end: Int): String {
        if (end >= s.length)
            return s.substring(0, start) + s.substring(start, s.length).reversed()
        return s.substring(0, start) + s.substring(start, end).reversed() + s.substring(end, s.length)
    }

    fun reverseStr(s: String, k: Int): String {
        var i = k

        if (s.length <= k)
            return s.reversed()

        var res = s.substring(0, k).reversed() + s.substring(k, s.length)

        i = 2 * k

        while (i < s.length) {
            res = reverseSubstring(res, i, i + k)
            i += 2*k
        }

        return res
    }
}