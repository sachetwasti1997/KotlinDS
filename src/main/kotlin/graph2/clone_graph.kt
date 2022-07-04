package graph2

import java.util.*
import kotlin.collections.HashMap

class Solution {
//    fun cloneGraph(node: Node?): Node? {
//        if(node == null)return node
//        var nodeMap = HashMap<Int, Node?>()
//        val q = LinkedList<Node>()
//        q.add(node)
//        while(!q.isEmpty()){
//            val temp = q.remove()
//            if(nodeMap[temp.`val`] == null)nodeMap[temp.`val`] = Node(temp.`val`)
//            for(i in temp?.neighbors.orEmpty()){
//                if(i != null && nodeMap[i.`val`] == null){
//                    nodeMap[i.`val`] = Node(i.`val`)
//                    q.add(i)
//                }
//                if(i != null)nodeMap[temp.`val`]?.neighbors?.add(nodeMap[i.`val`])
//            }
//        }
//        return nodeMap[node.`val`]
//    }
fun clone(node: Node?): Node?{
    if(node == null)return node
    val nodeMap = HashMap<Int?, Node?>()
    val q = LinkedList<Node?>()
    q.add(node)
    while(!q.isEmpty()){
        val temp = q.removeFirst()
        if(nodeMap[temp?.`val`] == null)nodeMap[temp?.`val`] = temp?.`val`?.let{Node(it)}
        for(i in temp?.neighbors.orEmpty()){
            if(nodeMap[i?.`val`] == null){
                nodeMap[i?.`val`] = i?.`val`?.let{Node(it)}
                q.add(i)
            }
            nodeMap[temp?.`val`]?.neighbors?.add(nodeMap[i?.`val`])
        }
    }
    return nodeMap[node.`val`]
}
}

class Solution2 {
    fun cloneGraph(node: Node?): Node? {
        if (node == null)return null
        val visited = HashMap<Int?, Node?>()
        var que = LinkedList<Node?>()
        que.add(node)
        while (!que.isEmpty()){
            val temp = que.poll()
            if (visited[temp?.`val`] == null)visited[temp?.`val`] = temp?.`val`?.let { Node(it) }
            for (i in temp?.neighbors ?: ArrayList()){
                if (visited[i?.`val`] == null) {
                    val n = i?.`val`?.let { Node(it) }
                    visited[i?.`val`] = n
                    que.add(i)
                }
                visited[temp?.`val`]?.neighbors?.add(visited[i?.`val`])
            }
        }
        return visited[node.`val`]
    }
}