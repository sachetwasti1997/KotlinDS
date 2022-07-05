package trees

fun isBalanced(root: TreeNode?): Boolean {
    fun height(root: TreeNode?): Int{
        if(root == null)return 0
        val left = height(root.left)
        val right = height(root.right)
        if(left == -1 || right == -1 || Math.abs(left - right) > 1)return -1
        return 1 + Math.max(left, right)
    }
    val h = height(root)
    return h != -1
}