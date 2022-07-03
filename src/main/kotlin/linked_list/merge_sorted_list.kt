package linked_list

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if(list1 == null)return list2
    if(list2 == null)return list1
    var l1 = list1
    var l2 = list2
    var newHead: ListNode? = null
    var tail: ListNode? = null
    while(l1 != null && l2 != null){
        var temp : ListNode? = null
        if(l1.`val` < l2.`val`) {
            temp = l1
            l1 = l1.next
        }else{
            temp = l2
            l2 = l2.next
        }
        if(newHead == null){
            newHead = temp
            tail = newHead
        }else{
            tail?.next = temp
            tail = tail?.next
        }
    }
    if(l1 != null)tail?.next = l1
    if(l2 != null)tail?.next = l2
    return newHead
}