class Solution {
    fun plusOne(head: ListNode?): ListNode? {
        val s = Stack<ListNode>()
        var h = head
        while(h != null){
            s.add(h)
            h = h?.next
        }       
        var carry = 0
        var total = 0
        while(!s.isEmpty()){
            h = s.pop()
            total += 1 + carry + h?.`val` ?: 0
            h?.`val` = total / 10
            carry = total % 10
        }
        if(carry != 0){
            val t = ListNode(carry)
            t.next = head
            h = t
        }
        return h
    }
}