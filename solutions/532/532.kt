fun findPairs(nums: IntArray, k: Int): Int {
    nums.sort()

    val visited = mutableMapOf<Int, Boolean>()
    var answ = 0

    for (num in nums) {
        if (visited.contains(num)) {
            if (k != 0 || visited[num] == true) continue
            visited[num] = true
            answ++
            continue
        }

        if (visited.contains(num + k)) {
            answ++
        }

        if (visited.contains(num - k)) {
            answ++
        }

        visited[num] = false
    }

    return answ
}