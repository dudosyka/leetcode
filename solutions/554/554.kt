fun leastBricks(wall: List<List<Int>>): Int {
    val edges = mutableMapOf<Int, Int>()
    var maxEdges = 0

    for (row in wall) {
        var w = 0
        for (brick in 0..<row.lastIndex) {
            w += row[brick]
            val edgeCount = edges.getOrDefault(w, 0) + 1
            maxEdges = max(maxEdges, edgeCount)
            if (maxEdges == wall.size) return 0
            edges[w] = edgeCount
        }
    }

    return wall.size - maxEdges
}