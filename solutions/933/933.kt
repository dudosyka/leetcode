class Node(val t: Int) {
    var prev: Node? = null
}

class Queue {
    var head: Node? = null
    var last: Node? = null
    var size: Int = 0

    fun addLast(t: Int) {
        val node = Node(t)
        val curLast = last
        if (curLast == null) {
            last = node
            node.prev = node
            head = node
        } else {
            curLast.prev = node
            last = node
        }
        size += 1
    }

    fun peekFirst(): Int? {
        return head?.t
    }

    fun removeFirst() {
        val curHead = head
        if (size == 0 || curHead == null) return
        
        if (curHead.prev == curHead) {
            head = null
            last = null
            size -= 1
            return
        }

        head = curHead.prev
        
        if (head == last) {
            head!!.prev = last
        }

        size -= 1
    }
}

class RecentCounter() {
    val queue = Queue()

    fun ping(t: Int): Int {

        var curFirst = queue.peekFirst()

        while (curFirst != null && (curFirst ?: 0) < (t - 3000)) {
            queue.removeFirst()
            curFirst = queue.peekFirst()
        }

        queue.addLast(t)

        return queue.size
    }

}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * var obj = RecentCounter()
 * var param_1 = obj.ping(t)
 */