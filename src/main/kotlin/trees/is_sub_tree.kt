package trees

fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
    if(root == null)return false
    fun sameTree(r1: TreeNode?, r2: TreeNode?): Boolean{
        if(r1 == null || r2 == null)return r1 == r2
        return sameTree(r1.left, r2.left) && sameTree(r1.right, r2.right) && r1.`val` == r2.`val`
    }
    var eql = false
    if(root.`val` == subRoot?.`val`)eql = sameTree(root, subRoot)
    val left = isSubtree(root.left, subRoot)
    val right = isSubtree(root.right, subRoot)
    return eql || left || right
}