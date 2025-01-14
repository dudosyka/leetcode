fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
    val queue = ArrayDeque<Pair<Int, Int>>()
    val visited = mutableSetOf<Pair<Int, Int>>()
    
    for (i in mat.indices) {
        for (j in mat[i].indices) {
            if (mat[i][j] == 0) {
                queue.addLast(Pair(i, j))
            }
        }
    }
    
    val directions = arrayOf(
        Pair(1, 0), Pair(0, 1), Pair(-1, 0), Pair(0, -1)
    )

    while (queue.isNotEmpty()) {
        val (x, y) = queue.removeFirst()

        for (dir in directions) {
            val x2 = x + dir.first
            val y2 = y + dir.second

            if (x2 < 0 || x2 > mat.size - 1 || y2 < 0 || y2 > mat[0].size - 1 || mat[x2][y2] == 0 || visited.contains(Pair(x2, y2))) continue

            mat[x2][y2] = mat[x][y] + 1
            visited.add(Pair(x2, y2))

            queue.addLast(Pair(x2, y2))
        }

    }

    return mat
}