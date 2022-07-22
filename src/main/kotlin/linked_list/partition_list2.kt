class Solution {
    fun partition(head: ListNode?, x: Int): ListNode? {
        val h1 = ListNode(-1)
        val h2 = ListNode(-1)
        var hd1: ListNode? = h1
        var hd2: ListNode? = h2
        var h = head
        while(h != null){
            if(h.`val` >= x){
                hd2?.next = ListNode(h.`val`)
                hd2 = hd2?.next
            }else{
                hd1?.next = ListNode(h.`val`)
                hd1 = hd1?.next
            }
            h = h.next
        }  
        hd1?.next = h2.next
        return h1.next
    }
}