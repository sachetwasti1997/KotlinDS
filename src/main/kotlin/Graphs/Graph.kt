package Graphs

import java.util.LinkedList
import java.util.Queue

class Node(var `val`: Int){
    var neighbors = ArrayList<Node?>()
}

fun cloneGraph(node: Node?): Node? {
    if(node == null)return null
    var nodeMap = HashMap<Int, Node>()
    var que: Queue<Node> = LinkedList()
    que.add(node)
    while(!que.isEmpty()){
        val nodeR = que.remove()
        if(!nodeMap.containsKey(nodeR.`val`)){
            nodeMap[nodeR.`val`] = nodeR
        }

        for(s in nodeR.neighbors){
            if (!nodeMap.containsKey(s!!.`val`)){
                val childNode = Node(s.`val`)
                que.add(s)
                nodeMap[s.`val`] = childNode
            }else{
                nodeMap[s.`val`]?.neighbors?.add(nodeMap[s.`val`])
            }
        }
    }
    return nodeMap[node.`val`]
}