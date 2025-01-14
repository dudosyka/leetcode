class Solution {
    fun apply(chars: CharArray, result: Int, string: String) {
        var i = 0;
        for (char in string) {
            chars[i + result] = char;
            i++
        }
    }

    fun compress(chars: CharArray): Int {
        var charOnCompress: Char? = null
        var numberOfChars: Int = -1
        var result: Int = 0
        for (char in chars) {
            if (charOnCompress == null) {
                charOnCompress = char
                numberOfChars = 1
                chars[result] = char
                result += 1
                continue;
            } 

            if (char != charOnCompress) {
                if (numberOfChars > 1) {
                    apply(chars, result, numberOfChars.toString());
                    result += numberOfChars.toString().length
                }

                chars[result] = char
                result += 1
                charOnCompress = char
                numberOfChars = 1
            } else {
                numberOfChars += 1
            }
        }

        if (numberOfChars > 1) {
            apply(chars, result, numberOfChars.toString());
            result += numberOfChars.toString().length
        }
    

        return result;
    }
}