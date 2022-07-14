package heaps

import java.util.*

class KthLargest(val k: Int, val nums: IntArray) {

    val pq = PriorityQueue<Int>()

    init{
        for(i in nums)pq.add(i)
    }

    fun add(`val`: Int): Int {
        pq.add(`val`)
        while(pq.size > k){
            pq.remove()
        }
        return pq.peek()
    }

}