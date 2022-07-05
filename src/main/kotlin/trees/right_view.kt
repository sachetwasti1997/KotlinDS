package trees

fun rightSideView(root: TreeNode?): List<Int> {
    if(root == null)return listOf<Int>()
    var max = -1
    val res = mutableListOf<Int>()
    fun inorder(root: TreeNode?, curr: Int){
        if(root == null)return
        if(max < curr){
            max = curr
            res.add(root.`val`)
        }
        inorder(root.right, curr+1)
        inorder(root.left, curr+1)
    }
    inorder(root, 0)
    return res
}