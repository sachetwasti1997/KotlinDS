class Solution {
    fun plusOne(head: ListNode?): ListNode? {
        if(head == null)return null
        val s: ListNode? = ListNode(0)
        s?.next = head       
        var h = s
        var nonNine: ListNode? = null
        while(h != null){
            if(h.`val` != 9)nonNine = h
            h = h.next
        }
        nonNine?.`val` = nonNine?.`val`?.plus(1)
        nonNine = nonNine?.next
        while(nonNine != null){
            nonNine.`val` = 0
            nonNine = nonNine.next
        }
        return if(s?.`val` == 0)s?.next else s 
    }
}