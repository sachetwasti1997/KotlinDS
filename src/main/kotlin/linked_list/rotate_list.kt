package linked_list

class Solution15 {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if(head?.next == null)return head
        var c = k
        var h = head
        var tail = h
        var count = 0
        while(tail != null){
            count++
            tail = tail.next
        }
        if(count < c)c = c % count
        tail = h
        for(i in 0 until c)tail = tail?.next
        var slow: ListNode? = null
        while(tail != null){
            if(slow == null)slow = h
            else slow = slow?.next
            tail = tail.next
        }
        var he = slow?.next
        slow?.next = null
        var hd = he
        while(he?.next != null)he = he.next
        he?.next = h
        return hd
    }
}

fun main(){
    val s = Solution15()
    val l1 = ListNode(1)
    val l2 = ListNode(2)
//    val l3 = ListNode(3)
//    val l4 = ListNode(4)
//    val l5 = ListNode(5)
    l1.next = l2
//    l2.next = l3
//    l3.next = l4
//    l4.next = l5
    s.rotateRight(l1, 2)
}