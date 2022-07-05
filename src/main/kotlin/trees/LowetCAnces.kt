package trees

fun lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): Int{
    val path1 = ArrayList<Int>()
    val path2 = ArrayList<Int>()
    
    fun findPath(root: TreeNode?, data: Int, path: ArrayList<Int>): Boolean{
        if (root == null){
            return false
        }
        if (root.data == data){
            path.add(root.data)
            return true
        }
        if (findPath(root.left, data, path) || findPath(root.right, data, path)){
            path.add(root.data)
            return true
        }
        return false
    }
    findPath(root, p.data, path1)
    findPath(root, q.data, path2)
    var i = path1.size - 1
    var j = path2.size - 1
    while (path1[i] == path2[j]){
        i--
        j--
    }
    return path1[i+1]
}

fun main(){
    val t1 = TreeNode(10)
    val t2 = TreeNode(50)
    val t3 = TreeNode(60)
    val t4 = TreeNode(70)
    val t5 = TreeNode(20)
    val t6 = TreeNode(40)
    val t7 = TreeNode(90)
    val t9 = TreeNode(80)
    val t10 = TreeNode(30)
    val t11 = TreeNode(36)
    t1.left = t2
    t1.right = t3
    t2.left = t4
    t2.right = t5
    t4.left = t6
    t5.left = t7
    t5.right = t9
    t7.left = t10
    t7.right = t11
    println(lowestCommonAncestor(t1, t10, t11))
}