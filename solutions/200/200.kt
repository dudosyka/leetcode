class Union() {
    val rank = mutableMapOf<Pair<Int, Int>, Int>()
    val parent = mutableMapOf<Pair<Int, Int>, Pair<Int, Int>>()

    fun makeSet(p: Pair<Int, Int>): Pair<Int, Int> {
        rank[p] = 0
        parent[p] = p
        return p
    }

    fun find(p: Pair<Int, Int>): Pair<Int, Int>? {
        if (parent[p] == null)
            return null
        var cur = parent[p]
        while (cur != parent[cur]) cur = parent[cur];
        return cur
    }

    fun union(p1: Pair<Int, Int>, p2: Pair<Int, Int>) {
        val parentP1 = find(p1) ?: makeSet(p1)
        val parentP2 = find(p2) ?: makeSet(p2)

        if (parentP1 == parentP2) return;

        if (rank[parentP1]!! > rank[parentP2]!!) {
            parent[parentP2] = parentP1
        } 
        else {
            parent[parentP1] = parentP2
        }

        if (rank[parentP1] == rank[parentP2]) {
            rank[parentP2] = rank[parentP2]!! + 1
        }
    }

    fun countSets(): Int {
        var count = 0

        parent.map {
            if (it.key == it.value)
                count += 1
        }

        return count
    }
}

class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val union = Union()

        for (i in grid.indices) {
            for (j in grid[i].indices) {
                val cell = grid[i][j]

                if (cell == '0')
                    continue

                union.makeSet(Pair(i, j))
                
                if (i > 0 && grid[i - 1][j] == '1') {
                    union.union(Pair(i, j), Pair(i - 1, j))
                }

                if (j > 0 && grid[i][j - 1] == '1') {
                    union.union(Pair(i, j), Pair(i, j - 1))
                }
            }
        }

        return union.countSets()
    }
}