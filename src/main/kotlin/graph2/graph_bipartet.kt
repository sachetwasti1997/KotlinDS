class Solution {
    fun isBipartite(graph: Array<IntArray>): Boolean {
        val g = HashSet<Int, List<Int>>()
        val part1 = HashSet<Int>()
        val part2 = HashSet<Int>()
        for(i in 0 until graph.size){
            for(j in 0 until graph[i].size){
                if(part1.contains(i)){
                    part2.add(graph[i][j])
                    
                }
                else if(part2.contains(i)){}
            }
        }       
    }
}