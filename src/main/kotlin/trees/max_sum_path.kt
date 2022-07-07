package trees

fun maxPathSum(root: TreeNode?): Int {
    var ans = Int.MIN_VALUE
    fun find(root: TreeNode?): Int{
        if(root == null)return 0
        val left = find(root.left)
        val right = find(root.right)
        val temp = root.`val` + Math.max(left, right)
        val anscurr = Math.max(temp, root.`val`+left+right)
        val curr = Math.max(anscurr, root.`val`)
        ans = Math.max(ans, curr)
        return Math.max(temp, root.`val`)
    }
    find(root)
    return ans
}