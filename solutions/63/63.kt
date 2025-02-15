fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
    val routes = Array(obstacleGrid.size) {
        IntArray(obstacleGrid[0].size) {
            0
        }
    }
    
    routes[0][0] = 1

    for (i in 0..obstacleGrid.lastIndex) {
        for (j in 0..obstacleGrid[0].lastIndex) {
            if (obstacleGrid[i][j] == 1) {
                routes[i][j] = 0
                continue;
            }
            if (i > 0) routes[i][j] += routes[i - 1][j]
            if (j > 0) routes[i][j] += routes[i][j - 1]
        }
    }

    return routes[obstacleGrid.lastIndex][obstacleGrid[0].lastIndex]
}