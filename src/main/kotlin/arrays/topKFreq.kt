class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val m = HashMap<Int, Int>()
        for(i in nums){
            if(m[i] == null)m[i] = 1
            else m[i] = m[i]!! + 1
        }
        val h = PriorityQueue<Pair<Int, Int>>(){a,b -> b.first - a.first}
        for(i in m)h.add(Pair(i.value, i.key))
        val s = HashSet<Int>()
        while(!h.isEmpty()){
            val t = h.remove()
            if(!s.contains(t.second))s.add(t.second)
            if(s.size == k)break
        }
        return s.toIntArray()
    }
}