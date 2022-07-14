import java.util.*

class Solution24 {
    fun lastStoneWeight(stones: IntArray): Int {
        val pq = PriorityQueue<Int>(){a,b -> b - a}
        for(i in stones)pq.add(i)
        while(pq.size >= 2){
            val y = pq.remove()
            val x = pq.remove()
            if(y > x){
                pq.add(y - x)
            }
        }
        return pq.remove()
    }
}