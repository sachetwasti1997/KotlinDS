class Solution {
    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        val o_deg = HashMap<Int, Int>(graph.size)
        val q = LinkedList<Int>()
        val g = HashMap<Int, ArrayList<Int>>(graph.size)
        for(i in graph.indices){
            o_deg[i] = graph[i].size
            if(o_deg[i] == 0)q.add(i)
            for(j in graph[i]){
                if(g[j] == null)g[i] = ArrayList<Int>()
                g[j].add(i)
            }
        }
        var res = mutableListOf<Int>()
        while(!q.isEmpty()){
            val zero_deg = q.pop()
            res.add(zero_deg)
            for(i in g[zero_deg]){
                o_deg[i]?.let{o_deg[i] = it - 1}
                if(o_deg[i] == 0)q.add(i)
            }   
        }
        return res.sorted()
    }
}