class Node(var k: Int, var v: Int) {
    var prev: Node? = null
    var next: Node? = null
}

class DoubleLinkedList() {
    var head: Node? = null
    var tail: Node? = null

    fun addFirst(node: Node) {
        val curHead = head
        if (curHead == null) {
            head = node
            tail = node
            node.next = head
            node.prev = tail
        } else {
            curHead.next = node
            node.next = null
            node.prev = curHead
            if (curHead.k == tail?.k)
                curHead.prev = null
            head = node
        }
    }

    fun removeLast(): Node? {
        val curTail = tail
        if (curTail == null) {
            return null
        } else {
            val newTail = curTail.next
            tail = newTail
            if (newTail == null || newTail.k == curTail.k) 
                head = null
            else {
                newTail.prev = null
                curTail.next = null
            }
            return curTail
        }
    }

    fun removeNode(node: Node) {
        val prev = node.prev
        val next = node.next

        if (prev != null) {
            prev.next = next
        }

        if (next != null) {
            next.prev = prev
        }

        if (node.k == tail?.k) {
            tail = node.next
        }

        if (node.k == head?.k && node.k == tail?.k) {
            head = null
            tail = null
        }
    }

    fun peekFirst(): Int? {
        return head?.k;
    }
}

class LRUCache(val capacity: Int) {
    val data = mutableMapOf<Int, Node>()
    val list = DoubleLinkedList()

    fun touch(node: Node, new: Boolean = false) {
        if (new) {
            list.addFirst(node)
            return;
        }

        if (node.k == list.peekFirst())
            return

        list.removeNode(node)
        list.addFirst(node)
    }

    fun get(key: Int): Int {
        val item = data[key]
        
        if (item == null)
            return -1
        
        touch(item)
        return data[key]?.v ?: -1
    }

    fun put(key: Int, value: Int) {
        val node = data[key]

        if (node == null && capacity == data.size) {
            val onRemove = list.removeLast()
            if (onRemove != null)
                data.remove(onRemove.k)
        }

        if (node == null) {
            val newNode = Node(key, value)
            data[key] = newNode
            touch(newNode, true)
        } else {
            node.v = value
            touch(node)
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */