/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    var cur: Int = 0

    fun convertBST(root: TreeNode?): TreeNode? {
        count(root)
        return root
    }

    fun count(node: TreeNode?) {
        if (node == null) return

        count(node.right)
        node.`val` += cur
        cur = node.`val`
        count(node.left)
    }
}