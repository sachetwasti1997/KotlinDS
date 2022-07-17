class Solution {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        if(head == null)return null
        var h = head
        while(h?.next != null){
            if(h.next?.`val` == `val`){
                h.next = h.next?.next 
            }
            h = h.next
        }       
        return h
    }
}