class Solution {
    fun middleNode(head: ListNode?): ListNode? {
        if(head?.next == null)return head
        val prev = head
        val curr = head
        while(curr?.next != null){
            curr = curr.next?.next
            prev = prev?.next
        }       
        return prev
    }
}