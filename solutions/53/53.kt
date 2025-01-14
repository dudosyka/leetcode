class Solution {
    val result = mutableListOf<String>()

    fun generate(s: String, n: Int, opening: Int, closing: Int) {
        if (s.length == n * 2) {
            result.add(s)
            return
        }

        if (opening < n) {
            generate(s + "(", n, opening + 1, closing)
        }

        if (closing < opening) {
            generate(s + ")", n, opening, closing + 1)
        }
    }

    fun generateParenthesis(n: Int): List<String> {
        generate("", n, 0, 0)
        return result
    }
}