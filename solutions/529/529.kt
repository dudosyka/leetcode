class Solution {
    fun Array<CharArray>.isMine(x: Int, y: Int): Boolean {
        if (x >= this.size || y >= this[0].size || y < 0 || x < 0) return false
        return this[x][y] == 'M'
    }

    val directions = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 0),
        intArrayOf(0, -1),
        intArrayOf(-1, 0),
        intArrayOf(1, -1),
        intArrayOf(-1, 1),
        intArrayOf(-1, -1),
        intArrayOf(1, 1)
    )

    fun updateBoard(board: Array<CharArray>, click: IntArray): Array<CharArray> {
        val mineClicked = propagate(click, board)
        if (mineClicked) {
            board[click[0]][click[1]] = 'X'
        }
        return board
    }

    //Return true if Mine found
    fun propagate(point: IntArray, board: Array<CharArray>): Boolean {
        val x = point[0]
        val y = point[1]

        if (x >= board.size || y >= board[0].size || y < 0 || x < 0) return false
        if (board[x][y] == 'M') return true
        if (board[x][y] == 'B') return false

        var mineAround = 0

        for (dir in directions) {
            val isMine = board.isMine(x + dir[0], y + dir[1])
            if (isMine) mineAround++
        }

        if (mineAround == 0) {
            board[x][y] = 'B'
            for (dir in directions) {
                propagate(intArrayOf(x + dir[0], y + dir[1]), board)
            }
        } else {
            board[x][y] = "$mineAround"[0]
        }

        return false
    }
}