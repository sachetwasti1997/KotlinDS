package linked_list

fun reverseList(head: ListNode?): ListNode? {
    if(head?.next == null) return head
    var prev: ListNode? = null
    var curr = head
    var next = head.next
    while(next != null){
        curr?.next = prev
        prev = curr
        curr = next
        next = next.next
    }
    curr?.next = prev
    return curr
}