package linked_list

class Solution12 {
    fun mergeNodes(head: ListNode?): ListNode? {
        var res: ListNode? = null
        head?.let{node ->
            var temp: ListNode? = node
            var tail = res
            while(temp != null){
                temp = temp.next
                var str = 0
                while(temp!= null && temp.`val` != 0){
                    temp?.`val`?.let{str += it}
                    temp = temp?.next
                }
                if(str > 0){
                    if(res == null){
                        res = ListNode(str)
                        tail = res
                    }
                    else{
                        tail?.next = ListNode(str)
                        tail = tail?.next
                    }
                }
            }
        }
        return res
    }
}

fun main(){
    val l1 = ListNode(0)
    val l2 = ListNode(1)
    val l3 = ListNode(2)
    val l4 = ListNode(0)
    l1.next = l2
    l2.next = l3
    l3.next = l4
    val s = Solution12()
    s.mergeNodes(l1)
//    val t = null != 1
//    println(t)
}