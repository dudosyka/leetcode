class Solution {
    fun addStrings(num1: String, num2: String): String {
        var l1 = num1.length - 1
        var l2 = num2.length - 1
        var next = 0
        var result = ""
        while (l1 >= 0 || l2 >= 0) {
            val f = if (l1 >= 0) num1[l1] - '0' else 0
            val s = if (l2 >= 0) num2[l2] - '0' else 0

            val curr = f + s + next
            next = (curr - (curr % 10)) / 10
            result = "${(curr - (next*10))}${result}"
            l1 -= 1
            l2 -= 1
        }

        if (next > 0)
            result = "${next}${result}"

        return result
    }
}