package trees

fun kthSmallest(root: TreeNode?, k: Int): Int {
    var index = 0
    var kthsmall = 0
    fun findSmall(root: TreeNode?){
        if(root == null)return
        findSmall(root.left)
        index++
        if(index == k){
            kthsmall = root.`val`
            return
        }
        findSmall(root.right)
    }
    findSmall(root)
    return kthsmall
}