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
    fun lessThan(node: TreeNode?, node2: TreeNode?): Boolean {
        return (node == null) || (node2 == null) || node.`val` < node2.`val`;
    }

    fun graterThan(node: TreeNode?, node2: TreeNode?): Boolean {
        return (node2 == null) || (node == null) || node.`val` > node2.`val`;
    }

    fun isValid(vert: TreeNode?, lastLeft: TreeNode?, lastRight: TreeNode?): Boolean {
        if (vert == null) {
            return true
        }

        return (
            lessThan(vert?.left, vert) &&
            graterThan(vert?.left, lastRight) &&
            graterThan(vert?.right, vert) &&
            lessThan(vert?.right, lastLeft) &&
            isValid(vert?.left, vert, lastRight) && 
            isValid(vert?.right, lastLeft, vert)
        )
    }

    fun isValidBST(root: TreeNode?): Boolean {
        return isValid(root, null, null)
    }
}