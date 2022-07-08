package linked_list

class Solution16 {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if(head?.next == null)return head
        var curr = head
        while(curr?.next != null){
            while(curr.`val` == curr.next?.`val`){
                curr.next = curr.next?.next
            }
            curr = curr?.next
        }
        return head
    }
}

fun main(){
    val s = Solution16()
    val l1 = ListNode(1)
    val l2 = ListNode(1)
    val l3 = ListNode(2)
    l1.next = l2
    l2.next = l3
    s.deleteDuplicates(l1)
}