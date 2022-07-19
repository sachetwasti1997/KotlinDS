class Solution {
    // fun oddEvenList(head: ListNode?): ListNode? {
    //     if(head?.next == null || head.next?.next == null)return head
    //     var even = head.next?.`val`?.let { ListNode(it) }
    //     var odd: ListNode? = ListNode(head.`val`)
    //     val eh = even
    //     val oh = odd
    //     var h = head.next
    //     var ho = head
    //     while(h?.next != null && ho?.next != null){
    //         even?.next = h.next?.next?.`val`?.let { ListNode(it) }
    //         odd?.next = ho.next?.next?.`val`?.let { ListNode(it) }
    //         even = even?.next
    //         odd = odd?.next
    //         h = h.next?.next
    //         ho = ho.next?.next
    //     }
    //     odd?.next = eh
    //     return oh
    // }
    fun oddEvenList(head: ListNode?): ListNode?{
        val oH = ListNode(-1)
        val eH = ListNode(-1)
        var curr = head
        var odd: ListNode? = oH
        var even: ListNode? = eH
        while(curr != null){
            odd?.next = curr
            even?.next = curr.next
            odd = odd?.next
            even = even?.next
            curr = curr.next?.next
        }
        odd?.next = eH.next
        even?.next = null
        return oH.next
    }
}