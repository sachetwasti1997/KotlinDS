package linked_list

import java.util.*

class Solution20 {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if(lists.isEmpty())return null
        val pq = PriorityQueue<Pair<Int, ListNode?>>{a,b -> a.first - b.first}
        for(i in lists){
            if(i == null)continue
            pq.add(Pair(i.`val`, i.next))
        }
        var head: ListNode? = null
        var tail: ListNode? = null
        while(!pq.isEmpty()){
            val tmp = pq.poll()
            val first = tmp.first
            if(head == null){
                head = ListNode(first)
                tail = head
            }else{
                tail?.next = ListNode(first)
                tail = tail?.next
            }
            tmp.second?.let{
                val first = it.`val`
                val second = it.next
                pq.add(Pair(first, second))
            }
        }
        return head
    }
}