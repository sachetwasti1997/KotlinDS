class Solution {
    fun deleteNodes(head: ListNode?, m: Int, n: Int): ListNode? {
        if(head?.next == null)return head
        var h = head
        while(h != null){
            var m1 = m; var n1 = n
            while(h != null && m1 > 1){
                h = h.next
                m1--
            }
            var g = h?.next
            while(g != null && n1 > 1){
                g = g.next
                n1--
            }
            h?.next = g?.next
            h = h?.next
        }
        return h
    }
}