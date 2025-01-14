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
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null && l2 == null) return null
        if (l1 == null) return l2
        if (l2 == null) return l1

        val newNumHead = ListNode()
        var cur = newNumHead
        var n1 = l1
        var n2 = l2
        var onNext = 0
        while (n1 != null || n2 != null) {
            var result = onNext

            result += (n1?.`val` ?: 0)
            n1 = n1?.next

            result += (n2?.`val` ?: 0)
            n2 = n2?.next

            if (result >= 10) {
                onNext = (result - (result % 10)) / 10
                result = (result % 10)
            } else {
                onNext = 0
            }

            val digit = ListNode(result)
            cur.next = digit
            cur = digit
        }

        if (onNext != 0) {
            val digit = ListNode(onNext)
            cur.next = digit
            cur = digit
        }

        return newNumHead.next
    }
}