class Solution {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        if(n == 1)return listOf(0)
        val deg = HashMap<Int, Int>(n)
        val g = HashMap<Int, ArrayList<Int>>(n)
        for(i in 0 until n){
            deg[i[0]] = 0
            deg[i[1]] = 0
            g[i] = ArrayList()
        }
        for(i in edges){
            deg[i[1]] = deg[i[0]]?.plus(1)
            deg[i[0]] = deg[i[1]]?.plus(1)
            g[i[0]]?.add(i[1])
            g[i[1]]?.add(i[0])
        }       
        val q = LinkedList<Int>()
        val v = HashSet<Int>(n)
        for(i in deg){
            if(i.value == 1){
                q.add(i.key)
                v.add(i.key)
            }
        }
        val res = ArrayList<Int>(n)
        while(!q.isEmpty()){
            res = ArrayList()
            for(i in 0 until q.size){
                val tmp = q.removeFirst()
                res.add(tmp)
                for(j in g[tmp].orEmpty()){
                    if(!v.contains(j)){
                        deg[j]?.let{deg[j] = it-1}
                        if(deg[j] == 1){
                            v.add(j)
                            q.add(j)
                        }
                    }
                }
            }
        }
    }
}