class Node(val char: Char) {
    var prev: Node? = null
}

class Stack() {
    var head: Node? = null

    fun addFirst(char: Char) {
        val node = Node(char);
        node.prev = head;
        head = node;
    }

    fun peekFirst(): Char? {
        val curHead = head;
        if (curHead == null)
            return null
        else
            return curHead.char;
    }

    fun removeFirst(): Char? {
        val curHead = head;
        if (curHead == null) 
            return null
        else {
            val prev = curHead.prev;
            head = prev;
            return curHead.char
        }
    }
}

class Solution {
    fun isValid(s: String): Boolean {
        val stack = Stack();

        for (char in s) {
            if (char == '(' || char == '[' || char == '{') {
                stack.addFirst(char);
            } else {
                val first = stack.removeFirst();
                
                if (first == null)
                    return false;

                if ((first == '(' && char != ')') ||
                    (first == '[' && char != ']') ||
                    (first == '{' && char != '}') )
                    return false;
            }
        }

        return (stack.peekFirst() == null) 
    }
}