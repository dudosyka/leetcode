fun uniquePaths(m: Int, n: Int): Int {
    val routes = Array(m) {
        IntArray(n) {0}
    }

    routes[0][0] = 1

    for (i in 0..(m - 1)) {
        for (j in 0..(n - 1)) {
            if (j > 0) routes[i][j] += routes[i][j - 1]
            if (i > 0) routes[i][j] += routes[i - 1][j]
        }
    }
    
    return routes[m - 1][n - 1]
}