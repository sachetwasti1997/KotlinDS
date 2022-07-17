class Solution {
    fun isBipartite(graph: Array<IntArray>): Boolean {
        val g = HashMap<Int, ArrayList<Int>>()
        for(i in 0 until graph.size){
            for(j in 0 until graph[i].size){
                if(g[i] == null)g[i] = ArrayList()
                g[i]?.add(graph[i][j])
            }
        }
        val q = LinkedList<Pair<Int, Int>>()
        val p1 = mutableSetOf(0)
        val p2 = HashSet<Int>()
        val v = HashSet<Int>()
        
        for(i in 0 until g.size){
            if(v.contains(i))continue
            q.add(Pair(i, 1))
            while(!q.isEmpty()){
            val t = q.removeFirst()
            for(i in g[t.first].orEmpty()){
                if(t.second == 1){
                    if(p1.contains(i))return false
                    p2.add(i)
                }else{
                    if(p2.contains(i))return false
                    p1.add(i)
                }
                if(v.contains(i))continue
                v.add(i)
                if (t.second == 1) q.add(Pair(i, 2)) else q.add(Pair(i, 1))
            }
            }
        }
        return true
    }
}