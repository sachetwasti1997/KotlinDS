class Solution {
    fun isBipartite(graph: Array<IntArray>): Boolean {
        val g = HashSet<Int, List<Int>>()
        val part1 = HashSet<Int>()
        val part2 = HashSet<Int>()
        val v = HashSet<Int>()

        fun dfs(n: Int, part: Int):Boolean{
            if(part == 2){
                if(part2.contains(n))return false
                part1.add(n)
            }else{
                if(part1.contains(n))return false
                part2.add(n)
            }
            v.add(n)
            for(i in g[n].orEmpty()){
                if(!v.contains(i) && !dfs(i))return false
            }
            return true
        }
        
        
        for(i in 0 until graph.size){
            for(j in 0 until graph[0]){
                if(g[i] == null)g[i] = ArrayList<>()
                g[i]?.add(graph[i][j])
            }
        }       

        for(i in g){
            if(!v.contains(i.key) && !dfs(i.key))return false
        }

        return true
    }
}