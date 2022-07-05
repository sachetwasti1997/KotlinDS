package trees

fun isValidBST(root: TreeNode?): Boolean {
    fun findIsValid(root: TreeNode?, left: Long?, right: Long?): Boolean{

        if(root == null)return true
        val leftB = findIsValid(root.left, left, root.`val`.toLong())
        val rightB = findIsValid(root.right, root.`val`.toLong(), right)
        val leftval = left ?: root.`val`.toLong()
        val rightval = right ?: root.`val`.toLong()
        return leftB && rightB && (root.`val` > leftval) && root.`val` < rightval

    }
    return findIsValid(root, Long.MIN_VALUE, Long.MAX_VALUE)
}