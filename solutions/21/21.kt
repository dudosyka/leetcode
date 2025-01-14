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
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var cur1 = list1
        var cur2 = list2

        if (cur1 == null) return cur2
        if (cur2 == null) return cur1


        val head = if (cur1!!.`val` <= cur2!!.`val`) {
            cur1 = list1?.next
            ListNode(list1!!.`val`)
        } else {
            cur2 = list2?.next
            ListNode(list2!!.`val`)
        }

        var new = head

        while (cur1 != null && cur2 != null) {
            while (cur1 != null && cur1!!.`val` <= cur2!!.`val`) {
                new.next = cur1
                new = new.next
                cur1 = cur1?.next
            } 

            if (cur1 == null)
                break

            while (cur2 != null && cur2!!.`val` <= cur1!!.`val`) {
                new.next = cur2
                new = new.next
                cur2 = cur2?.next
            } 
        }

        if (cur1 != null) new.next = cur1
        if (cur2 != null) new.next = cur2

        return head
    }
}