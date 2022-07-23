fun reverseKGroup2(head: ListNode?, k: Int): ListNode? {
    fun reverse(h: ListNode?): Pair<ListNode?, ListNode?>{
        if(h?.next == null)return Pair(h, null)
        var s = k - 1
        var hd = h
        var fast = h.next
        var prev: ListNode? = null
        while(fast != null && s > 0){
            hd?.next = prev
            prev = hd
            hd = fast
            fast = fast?.next
            s--
        }
        var tmp = hd?.next
        hd?.next = prev
        h?.next = tmp
        return Pair(hd, h)
    }
    var h = head
    var len = 0
    while(h!= null){
        h = h.next
        len++
    }
    var tmphd = head
    var nh: ListNode? = null
    var prev: ListNode? = null
    while(len >= k){
        val (hd,e) = reverse(tmphd)
        if(nh == null)nh = hd
        tmphd = e?.next
        prev?.next = hd
        prev = e
        len-=k
    }
    return nh
}