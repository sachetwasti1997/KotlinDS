package linked_list

class Node(var `val`: Int, var next: Node ?= null, var random: Node ?= null)

fun copyRandomList(node: Node?): Node? {
    if(node == null)return node
    val nodeMap = HashMap<Node?, Node?>()
    var head = node
    while(head != null){
        nodeMap[head] = Node(head.`val`)
        head = head.next
    }
    head = node
    while(head != null){
        nodeMap[head]?.next = nodeMap[head.next]
        nodeMap[head]?.random = nodeMap[head.random]
        head = head.next
    }
    return nodeMap[node]
}

fun random(node: Node?):Node?{
    fun copyRandomList(node: Node?): Node? {
        if(node == null)return node
        var h = node
        while(h != null){
            val temp = Node(h.`val`)
            temp.next = h.next
            h.next = temp
            h = h.next?.next
        }
        h = node
        while(h != null){
            h.next?.random = h.random?.next
            h = h.next?.next
        }
        h = node.next
        var n = node
        while(n?.next != null){
            val temp = n.next
            n.next = n.next?.next
            n = temp
        }
        return h
    }
    return copyRandomList(node)
}

fun main(){
    var l1 = Node(7)
    var l2 = Node(13)
    var l3 = Node(11)
    var l4 = Node(10)
    var l5 = Node(1)
    l1.next = l2
    l2.random = l1
    l2.next = l3
    l3.random = l5
    l3.next = l4
    l4.random = l3
    l4.next = l5
    l5.random = l1
    random(l1)
}