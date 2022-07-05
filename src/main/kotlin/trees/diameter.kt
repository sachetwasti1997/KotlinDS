package trees

fun diameterOfBinaryTree(root: TreeNode?): Int {
    var ans = 0
    fun diameter(root: TreeNode?): Int{
        if(root == null)return 0
        val left = diameter(root.left)
        val right = diameter(root.right)
        val temp = 1 + Math.max(left, right)
        val diam = Math.max(temp, 1+left+right)
        ans = Math.max(ans, diam)
        return temp
    }
    diameter(root)
    return ans - 1
}