package trees

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {

    if(p == null || q == null)return p == q
    val left = isSameTree(p.left, q.left)
    val right = isSameTree(p.right, q.right)
    return left && right && p.`val` == q.`val`

}