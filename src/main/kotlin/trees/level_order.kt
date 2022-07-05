package trees

import java.util.*

fun levelOrder(root: TreeNode?): List<List<Int>> {
    if(root == null)return listOf()
    val q = LinkedList<TreeNode>()
    q.add(root)
    var size = q.size
    val res = mutableListOf<List<Int>>()
    while(!q.isEmpty()){
        val tempList = mutableListOf<Int>()
        for(i in 0 until size){
            val temp = q.remove()
            tempList.add(temp.`val`)
            temp.left?.let{q.add(it)}
            temp.right?.let{q.add(it)}
        }
        size = q.size
        res.add(tempList)
    }
    return res
}