class Node(val n: Int) {
    var prev: Node? = null
}

class Stack() {
    var top: Node? = null

    fun add(n: Int) {
        val newTop = Node(n)
        val curTop = top
        top = newTop
        newTop.prev = curTop
    }

    fun pop(): Int? {
        val curTop = top
        if (curTop == null) 
            return null
        
        top = curTop.prev

        return curTop.n
    }

    fun peek(): Int? {
        val curTop = top
        if (curTop == null)
            return null

        return curTop.n
    }

    fun empty(): Boolean = (top == null)
}

class MyQueue() {
    val insertStack = Stack()
    val getStack = Stack()

    fun moveToGet() {
        while (!insertStack.empty()) {
            getStack.add(insertStack.pop()!!)
        }
    }

    fun push(x: Int) {
        insertStack.add(x)
    }

    fun pop(): Int {
        if (getStack.empty()) {
            moveToGet()
            return pop()
        }

        return getStack.pop() ?: 0
    }

    fun peek(): Int {
        if (getStack.empty()) {
            moveToGet()
            return peek()
        }

        return getStack.peek() ?: 0
    }

    fun empty(): Boolean {
        return (getStack.empty() && insertStack.empty())
    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */