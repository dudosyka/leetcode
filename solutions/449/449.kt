/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

 class Codec() {
    fun serRecurive(node: TreeNode?): String {
        if (node == null)
            return ""
        
        return "${node.`val`},${serRecurive(node.left)},${serRecurive(node.right)}"
    }

	// Encodes a tree to a single string.
    fun serialize(root: TreeNode?): String {
        return serRecurive(root)
    }

    fun desRecursive(parent: TreeNode, nodes: List<String>, index: Int): Int {
        if (index >= nodes.size) return index

        val rightStart = if (nodes[index] != "") {
            parent.left = TreeNode(nodes[index].toInt())

            desRecursive(parent.left!!, nodes, index + 1)
        } else index + 1

        if (rightStart >= nodes.size) return rightStart
        
        return if (nodes[rightStart] != "") {
            parent.right = TreeNode(nodes[rightStart].toInt())
            desRecursive(parent.right!!, nodes, rightStart + 1)
        } else rightStart + 1

    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        if (data == "") return null
        val nodes = data.split(",")
        val root = TreeNode(nodes[0].toInt())

        desRecursive(root, nodes, 1)

        return root
    }
}

/**
 * Your Codec object will be instantiated and called as such:
 * val ser = Codec()
 * val deser = Codec()
 * val tree: String = ser.serialize(root)
 * val ans = deser.deserialize(tree)
 * return ans
 */