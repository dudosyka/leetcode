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
    var minDiff = Int.MAX_VALUE
    var prev = Int.MAX_VALUE
    fun search(root: TreeNode?) {
        if (root == null) {
            return
        }
        
        search(root.left)
        if (prev != Int.MAX_VALUE) {
            minDiff = min(minDiff, abs(prev - root.`val`))
        }
        prev = root.`val`
        search(root.right)
    }

    fun getMinimumDifference(root: TreeNode?): Int {
        search(root)
        return minDiff
    }
}