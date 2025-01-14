class Solution {
    fun IntArray.x(): Int {
        return this[0]
    }

    fun IntArray.y(): Int {
        return this[1]
    }

    fun IntArray.incX() {
        this[0]++
    }

    fun IntArray.incY() {
        this[1]++
    }

    fun IntArray.decX() {
        this[0]--
    }

    fun IntArray.decY() {
        this[1]--
    }

    fun MutableList<IntArray>.placeNum(position: IntArray, n: Int) {
        this[position.y()][position.x()] = n
    }

    fun MutableList<IntArray>.canGo(x: Int, y: Int): Boolean {
        return  y < this.size && 
                y >= 0 && x >= 0 &&
                x < this[0].size && 
                this[y][x] == 0
    }

    fun MutableList<IntArray>.canGoLeft(position: IntArray): Boolean {
        return this.canGo(position.x() - 1, position.y())
    }

    fun MutableList<IntArray>.canGoRight(position: IntArray): Boolean {
        return this.canGo(position.x() + 1, position.y())
    }

    fun MutableList<IntArray>.canGoUp(position: IntArray): Boolean {
        return this.canGo(position.x(), position.y() - 1)
    }

    fun MutableList<IntArray>.canGoDown(position: IntArray): Boolean {
        return this.canGo(position.x(), position.y() + 1)
    }

    fun generateMatrix(n: Int): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        for (i in 1..n) {
            result += IntArray(n) {0} 
        }

        var rowsCreated = result.size == n
        var position = intArrayOf(0, 0)

        if (n == 1) {
            result.placeNum(position, 1)
            return result.toTypedArray()
        }
        var i = 1
        while (i < n*n) {
            while (result.canGoRight(position)) {
                result.placeNum(position, i)
                position.incX()
                i+=1
            }
            while (result.canGoDown(position)) {
                result.placeNum(position, i)
                position.incY()
                i+=1
            }
            while (result.canGoLeft(position)) {
                result.placeNum(position, i)
                position.decX()
                i+=1
            }
            while (result.canGoUp(position)) {
                result.placeNum(position, i)
                position.decY()
                i+=1
            }
        }

        result.placeNum(position, n*n)

        return result.toTypedArray()
    }
}