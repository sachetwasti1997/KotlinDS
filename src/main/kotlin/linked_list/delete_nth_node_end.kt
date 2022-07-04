package linked_list

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    var h = head
    var count = 0
    while(h != null){
        h = h.next
        count ++
    }
    h = head
    if(count == n){
        h = h?.next
        return h
    }
    var prev: ListNode? = null
    var curr = head
    var i = 0
    while(i < n){
        curr = curr?.next
        i++
    }
    while(curr != null){
        if(prev == null)prev = head
        else prev = prev.next
        curr = curr.next
    }
    prev?.next = prev?.next?.next
    return head
}