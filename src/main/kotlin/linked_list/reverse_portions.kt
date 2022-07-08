package linked_list

class Solution19 {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        if(head?.next == null)return head
        if(left == right)return head
        fun reverse(start: ListNode?, end: ListNode?): ListNode?{
            var prev: ListNode? = null
            var curr = start
            var fast = start?.next
            while(fast != end){
                curr?.next = prev
                prev = curr
                curr = fast
                fast = fast?.next
            }
            curr?.next = prev
            return curr
        }
        var l1 = head
        var before: ListNode? = null
        for(i in 0 until left-1){
            if(before == null)before = head
            else before = before?.next
            l1 = l1?.next
        }
        var l2 = head
        for(i in 0 until right-1)l2 = l2?.next
        l2 = l2?.next
        val after = l2
        l1 = reverse(l1, l2)
        before?.next = l1
        var h = l1
        while(l1?.next != null)l1 = l1?.next
        l1?.next = after
        if(left == 1)return h
        return head
    }
}

fun main(){
    val l1 = ListNode(1)
    val l2 = ListNode(2)
    val s = Solution19()
    l1.next = l2
    val t = s.reverseBetween(l1, 1, 2)
    println(t)
}