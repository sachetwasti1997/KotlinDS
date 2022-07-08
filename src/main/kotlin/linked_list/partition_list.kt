package linked_list

class Solution21 {
    fun partition(head: ListNode?, x: Int): ListNode? {
        var h1: ListNode? = null
        var h2: ListNode? = null
        var h3: ListNode? = null
        var h4: ListNode? = null
        var hd = head
        while(hd != null){
            if(hd.`val` < x){
                if(h1 == null){
                    h1 = ListNode(hd.`val`)
                    h2 = h1
                }else{
                    h2?.next = ListNode(hd.`val`)
                    h2 = h2?.next
                }
            }else{
                if(h3 == null){
                    h3 = ListNode(hd.`val`)
                    h4 = h3
                }else{
                    h4?.next = ListNode(hd.`val`)
                    h4 = h4?.`next`
                }
            }
            hd = hd.next
        }
        if(h1 == null) return h3
        h2?.next = h3
        return h1
    }
}

fun main(){
    val l1 = ListNode(1)
    val l2 = ListNode(4)
    val l3 = ListNode(3)
    val l4 = ListNode(2)
    val l5 = ListNode(5)
    val l6 = ListNode(2)
//    l1.next = l2
//    l2.next = l3
//    l3.next = l4
//    l4.next = l5
//    l5.next = l6
    val s = Solution21()
    s.partition(l1, 0)
}