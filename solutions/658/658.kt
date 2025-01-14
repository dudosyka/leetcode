class Solution {
    fun Int.dist(x: Int): Int {
        return (this - x).absoluteValue
    }

    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        if (k == arr.size)
            return arr.toList()

        var closest: Int? = null;

        for (i in 1..(arr.size - 1)) {
            val prev = arr[i - 1]
            val cur = arr[i]

            if (cur.dist(x) > prev.dist(x)) {
                closest = i - 1
                break
            }
        }

        if (closest == null) {
            closest = arr.size - 2
        }

        val result = ArrayDeque<Int>()
        
        var left = closest - 1
        var right = closest

        while (result.size < k) {
            if (left < 0) {
                result.addLast(arr[right])
                right += 1
                continue
            }

            if (right >= arr.size) {
                result.addFirst(arr[left])
                left -= 1
                continue
            }

            val leftDist = arr[left].dist(x)
            val rightDist = arr[right].dist(x)


            if (leftDist < rightDist) {
                result.addFirst(arr[left])
                left -= 1
            } 
            else if (rightDist < leftDist) {
                result.addLast(arr[right])
                right += 1
            }
            else {
                if (arr[left] < arr[right]) {
                    result.addFirst(arr[left])
                    left -= 1
                } else {
                    result.addFirst(arr[right])
                    right += 1
                }
            }

        }

        return result.toList()
    }
}