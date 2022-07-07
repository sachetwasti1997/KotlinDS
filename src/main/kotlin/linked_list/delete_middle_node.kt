package linked_list

class Solution13 {
    fun deleteMiddle(head: ListNode?): ListNode? {
        head?.next?.let{
            var prev: ListNode? = null
            var fast: ListNode? = head
            while(fast?.next != null){
                if(prev == null)prev = fast
                else prev = prev?.next
                fast = fast.next?.next
            }
            prev?.next = prev?.next?.next
            return head
        }
        return head?.next
    }
}