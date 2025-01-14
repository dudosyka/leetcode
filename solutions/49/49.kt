class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val result = mutableMapOf<String, MutableList<String>>()
        for (str in strs) {
            val charArray = str.toCharArray()
            charArray.sort()
            val sorted = String(charArray)
            if (result[sorted] == null) {
                result[sorted] = mutableListOf<String>()
            }
            result[sorted]!!.add(str)
        }
        return result.values.toList()
    }
}