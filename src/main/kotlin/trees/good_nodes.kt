package trees

fun goodNodes(root: TreeNode?): Int {
    fun findGoodNodes(root: TreeNode?, prevGreat: Int): Int{
        if(root == null)return 0
        var res = 0
        var currGreat = prevGreat
        if(root.`val` >= currGreat){
            res = 1
            currGreat = root.`val`
        }
        val left = findGoodNodes(root.left, currGreat)
        val right = findGoodNodes(root.right, currGreat)
        return res + left + right
    }
    val c = findGoodNodes(root, Int.MIN_VALUE)
    return c
}