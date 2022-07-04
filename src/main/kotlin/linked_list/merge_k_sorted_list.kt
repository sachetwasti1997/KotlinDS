package linked_list

import java.util.*

class PairN(val n: Int, var node: ListNode? = null)

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    if(lists.isEmpty())return null
    val heap = PriorityQueue<PairN>(){a, b -> a.n - b.n}
    for(i in lists){
        if(i != null)heap.add(PairN(i.`val`, i.next))
    }
    var head: ListNode? = null
    var tail: ListNode? = null
    while(!heap.isEmpty()){
        val t = heap.remove()
        if(head == null){
            head = ListNode(t.n)
            tail = head
        }else{
            tail?.next = ListNode(t.n)
            tail = tail?.next
        }
        if(t.node != null){
            val p = t.node?.let{PairN(it.`val`, it.next)}
            heap.add(p)
            //Smart cast to 'ListNode' is impossible, because 't.node'
            // is a mutable property that could have been changed by this time
        }
    }
    return head
}