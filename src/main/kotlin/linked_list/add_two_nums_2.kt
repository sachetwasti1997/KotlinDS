class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        fun reverse(h: ListNode?): ListNode?{
            if(h?.next == null)return h
            var prev: ListNode? = null
            var curr = h
            var nxt = h.next
            while(nxt != null){
                curr?.next = prev
                prev = curr
                curr = nxt
                nxt = nxt?.next
            }
            curr?.next = prev
            return curr
        }       
        var list1 = reverse(l1)
        var list2 = reverse(l2)
        var res = ListNode(-1)
        var h: ListNode? = res
        var carry = 0
        while(list1 != null || list2 != null){
            val x = list1?.`val` ?: 0
            val y = list2?.`val` ?: 0
            val t = carry + x + y
            carry = t / 10
            h?.next = ListNode(t%10)
            h = h?.next
            list1 = list1?.next
            list2 = list2?.next
        }
        if(carry > 0)h?.next = ListNode(carry)
        return reverse(res?.next)
    }
}