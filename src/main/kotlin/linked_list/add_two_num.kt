package linked_list

fun addTwoNumbers(list1: ListNode?, list2: ListNode?): ListNode? {
    var l1 = list1
    var l2 = list2
    var carry = 0
    var head: ListNode? = null
    var tail: ListNode? = null
    while(l1 != null || l2 != null){
        val x = l1?.`val` ?: 0
        val y = l2?.`val` ?: 0
        val total = x + y + carry
        carry = total / 10
        if(head == null){
            head = ListNode(total%10)
            tail = head
        }else{
            tail?.next = ListNode(total%10)
            tail = tail?.next
        }
        l1 = l1?.next
        l2 = l2?.next
    }
    if(carry != 0){
        tail?.next = ListNode(carry)
    }
    return head
}