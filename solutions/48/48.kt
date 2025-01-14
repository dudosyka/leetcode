class Solution {
    fun transpose(matrix: Array<IntArray>) {
        for (i in 0..(matrix.size - 1)) {
            for (j in i..(matrix.size - 1)) {
                if (i == j) continue;

                val c = matrix[i][j]
                
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = c
            }
        }
    }

    fun reverseCols(matrix: Array<IntArray>) {
        for (i in matrix.indices) {
            var start = 0
            var end = matrix[i].size - 1
            while (start < end) {
                val c = matrix[i][start]
                matrix[i][start] = matrix[i][end]
                matrix[i][end] = c

                start += 1
                end -= 1
            }
        }   
    }

    fun rotate(matrix: Array<IntArray>): Unit {
        transpose(matrix)
        reverseCols(matrix)
    }
}