package linked_list

fun reorderList(head: ListNode?): Unit {
    if(head?.next == null)return
    fun reverse(head: ListNode?): ListNode?{
        if(head?.next == null)return head
        var prev: ListNode? = null
        var curr = head
        var fast = head.next
        while(fast != null){
            curr?.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        }
        curr?.next = prev
        return curr
    }
    var prev: ListNode? = null
    var curr = head
    var next = head
    while(next?.next != null){
        prev = curr
        curr = curr?.next
        next = next.next?.next
    }
    prev?.next = null
    curr = reverse(curr)
    var h = head.next
    val newHead = head
    var tail = newHead
    var isHead = false
    while(h!= null && curr != null){
        if(isHead){
            tail?.next = h
            isHead = false
            h = h?.next
        }else{
            tail?.next = curr
            isHead = true
            curr = curr?.next
        }
        tail = tail?.next
    }
    if(h != null) tail?.next = h
    if(curr != null) tail?.next = curr
}

fun main(){
    val l1 = ListNode(1)
    val l2 = ListNode(2)
    val l3 = ListNode(3)
    val l4 = ListNode(4)
    val l5 = ListNode(5)

    l1.next = l2
    l2.next = l3
    l3.next = l4
    l4.next = l5

    reorderList(l1)
}