/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var cur = head
        var end = head
        var sz = 0
        val map = mutableMapOf<Int, ListNode>()
        
        for (i in 1..n) {
            end = end!!.next
        }

        if (end == null) return head?.next

        while (end?.next != null) {
            end = end?.next
            cur = cur!!.next
        }

        cur!!.next = cur!!.next!!.next

        return head
    }
}