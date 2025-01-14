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
    fun isPalindrome(head: ListNode?): Boolean {
        if (head == null)
            return true

        var listLength = 1;
        var countHead = head
        while (countHead?.next != null) {
            countHead = countHead.next
            listLength++
        }

        var secondPartHead = head
        for (i in 0..((listLength / 2) - 1))
            secondPartHead = secondPartHead?.next

        if ((listLength % 2) != 0)
            secondPartHead = secondPartHead?.next

        var firstPartHead: ListNode? = ListNode(head!!.`val`)
        var next = head.next

        for (i in 1..((listLength / 2) - 1)) {
            val newHead = next
            next = next?.next
            newHead!!.next = firstPartHead
            firstPartHead = newHead
        }

        for (i in 0..((listLength / 2) - 1)) {
            if (secondPartHead?.`val` == firstPartHead?.`val`) {
                secondPartHead = secondPartHead?.next
                firstPartHead = firstPartHead?.next
            } else {
                return false
            }
        }

        return true
    }
}