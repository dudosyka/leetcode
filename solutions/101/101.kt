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
    fun checkSymmetric(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null && right == null) return true
        if (left == null || right == null) return false
        return left.`val` == right.`val` && checkSymmetric(left.left, right.right) && checkSymmetric(left.right, right.left)
    }

    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return true;

        return checkSymmetric(root?.left, root?.right)
    }
}