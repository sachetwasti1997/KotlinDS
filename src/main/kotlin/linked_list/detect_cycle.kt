package linked_list

fun hasCycle(head: ListNode?): Boolean {

    if(head == null)return false
    var fast = head
    var curr = head
    while(fast?.next != null){
        fast = fast.next?.next
        curr = curr?.next
        if(curr == fast)return true
    }
    return false

}