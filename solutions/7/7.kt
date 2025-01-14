class Solution {
    fun reverse(x: Int): Int {
        if (x == 0) return 0

        var res = 0
        
        for (i in 0..(x.toString().length - 1)) {
            res += try {
                (((x % Math.pow(10.0, (i + 1).toDouble())).toInt() / Math.pow(10.0, i.toDouble()).toInt()).toInt() * Math.pow(10.0, x.toString().length - 1 - i.toDouble())).toInt()
            } catch (e: NumberFormatException) {
                return 0
            }
        }

        return res
    }
}