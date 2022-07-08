package linked_list

import java.util.*

class Solution17 {
    fun sortList(head: ListNode?): ListNode? {
        if(head == null)return head
        val pq = PriorityQueue<Int>()
        var h = head
        while(h != null){
            pq.add(h.`val`)
            h = h.next
        }
        h = null
        var tail: ListNode? = null
        while(!pq.isEmpty()){
            val p = pq.remove()
            if(h == null){
                h = ListNode(p)
                tail = h
                continue
            }
            tail?.next = ListNode(p)
            tail = tail?.next
        }
        return h
    }
}