fun jump(nums: IntArray): Int {
    //<Distance, VertexIndex> 
    val queue = ArrayDeque<Pair<Int, Int>>()
    val dists = IntArray(nums.size) { Int.MAX_VALUE }

    queue.addLast(Pair(0, 0))
    dists[0] = 0

    while (queue.isNotEmpty()) {
        val (curDist, curVertex) = queue.removeFirst()
        val neighbors = nums[curVertex]

        if (curVertex == nums.size - 1) 
            return dists[curVertex]

        if (curDist > dists[curVertex]) continue

        for (i in 1..neighbors) {
            val neighbor = i + curVertex
            val dist = curDist + 1

            if (neighbor < nums.size && dist < dists[neighbor]) {
                dists[neighbor] = dist
                queue.addLast(Pair(dist, neighbor))
            }
        }
    }

    return dists[nums.size - 1]
}