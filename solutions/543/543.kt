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
    var size: Int = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        goDown(root)
        return size
    }

    fun goDown(node: TreeNode?): Int {
        if (node == null) return 0
        val leftSize = goDown(node.left)
        val rightSize = goDown(node.right)
        size = max(size, leftSize + rightSize)
        return max(leftSize, rightSize) + 1
    }
}