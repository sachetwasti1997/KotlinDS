class Solution {
    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        val res = ArrayList<ArrayList<Int>>()
        val t = ArrayList<Int>()
        val visited = HashSet<Int>()
        val target = graph.size - 1
        fun dfs(node: Int){
            visited.add(node)
            t.add(node)
            if(node == target){
                res.add(ArrayList(t))
            }
            for(i in graph[node]){
                if(!visited.contains(i)){
                    dfs(i)
                }
            }
            t.removeAt(t.size-1)
        }
        dfs(0)
        return res
    }
}