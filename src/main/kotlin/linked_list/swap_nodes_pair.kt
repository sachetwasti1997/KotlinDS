fun swapPairs(head: ListNode?): ListNode? {
        if(head?.next == null) return head
        fun reverse(h: ListNode?): ListNode?{
            val nxt = h?.next
            h?.next = nxt?.next
            nxt?.next = h
            return nxt
        }       
        var prev: ListNode? = null
        var curr = head
        var two = head?.next
        val h = head?.next
        while(curr?.next != null){
            curr = reverse(curr)
            prev?.next = curr
            prev = curr?.next
            curr = curr?.next?.next
        }
        return h
}