class Union {
    val parent = mutableMapOf<Int, Int>()
    val rank = mutableMapOf<Int, Int>()

    fun makeSet(n: Int): Int {
        parent[n] = n
        rank[n] = 0
        return n
    }

    fun find(n: Int): Int? {
        if (parent[n] != null && parent[n] != n)
            return find(parent[n]!!)
        else if (parent[n] == n)
            return n
        else
            return null

    }

    fun union(a: Int, b: Int) {
        val parentA = find(a) ?: makeSet(a)
        val parentB = find(b) ?: makeSet(b)

        if (parentA == parentB) return

        val rankA = rank[parentA]!!
        val rankB = rank[parentB]!!

        if (rankA > rankB) {
            parent[parentB] = a
        } else {
            parent[parentA] = b
        }

        if (rankA == rankB) {
            rank[b] = rank[b]!! + 1
        }
    }

    fun countSets(): Int {
        var i = 0
        parent.forEach { key, value ->
            if (key == value) i++
        }
        return i
    }
}

class Solution {
    fun findCircleNum(isConnected: Array<IntArray>): Int {
        val union = Union()

        for (i in isConnected.indices) {
            for (j in isConnected[i].indices) {
                if (isConnected[i][j] == 1) {
                    union.union(i, j)
                }
            }
        }

        return union.countSets()
    }
}