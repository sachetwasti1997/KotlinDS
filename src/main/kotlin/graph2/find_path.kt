class Solution {
    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        val v = HashSet<Int>(n)
        val g = HashMap<Int, ArrayList<Int>>(n)
        for(i in edges){
            if(g[i[0]] == null)g[i[0]] = ArrayList()
            if(g[i[1]] == null)g[i[1]] = ArrayList()
            g[i[0]]?.add(i[1])
            g[i[1]]?.add(i[0])
        }
        fun dfs(node: Int, d: Int): Boolean{
            v.add(node)
            if(d == node)return true
            for(i in g[n].orEmpty()){
                if(!v.contains())dfs(i, d)
            }
            return false
        }       
        return dfs(source, destination)
    }
}