class Solution {
    fun findCenter(edges: Array<IntArray>): Int {
        val c = HashMap<Int, Int>(edges.size)
        val graph = HashMap<Int, ArrayList<Int>>()
        for(i in edges){
            if(graph[i[0]] == null)graph[i[0]] = ArrayList()
            if(graph[i[1]] == null)graph[i[1]] = ArrayList()
            graph[i[0]]?.add(i[1])
            graph[i[1]]?.add(i[0])
            c[i[0]] = 1
            c[i[1]] = 1
        }
        val visit = HashSet<Int>()
        fun dfs(node:Int){
            visit.add(node)
            for(i in graph[node].orEmpty()){
                if(!visit.contains(i))dfs(i)
                if(visit.contains(i)){
                    if(c[i] == null)c[i] = 1
                    else c[i] = c[i]!! + 1
                }
            }
        }
        dfs(edges[0][0])
        var lar = -1; var res = -1
        for(i in c){
            if(lar < i.value){
                lar = i.value
                res = i.key
            }
        }
        return res
    }
}