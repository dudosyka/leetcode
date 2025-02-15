fun minPathSum(grid: Array<IntArray>): Int {
    val routes = Array(grid.size) {
        IntArray(grid[0].size) {
            Int.MAX_VALUE
        }
    }
    
    routes[0][0] = grid[0][0]

    for (i in 0..grid.lastIndex) {
        for (j in 0..grid[0].lastIndex) {
            if (i > 0) grid[i][j] = min(routes[i][j], routes[i - 1][j] + grid[i][j])
            if (j > 0) grid[i][j] = min(grid[i][j], routes[i][j - 1] + grid[i][j])
        }
    }

    return routes[grid.lastIndex][grid[0].lastIndex]
}