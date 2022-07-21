class Solution {
    fun isBipartite(graph: Array<IntArray>): Boolean {
        val m = HashMap<Int, Int>()

        fun findBiPart(n: Int): Boolean{
            val q = LinkedList<Int>()
            m[n] = -1
            q.add(n)
            while(!q.isEmpty()){
                val t = q.removeFirst()
                for(i in graph[t]){
                    if(m[i] == null){
                        q.add(i)
                    }
                    if(m[t] == -1){
                        if(m[i] == -1)return false
                        m[i] = 1
                    }else{
                        if(m[i] == 1)return false
                        m[i] = -1
                    }
                }
            }
            return true
        }

        for(i in graph.indices){
            if(m[i] == null && !findBiPart(i))return false
        }
        return true
    }

    fun isBipartite1(graph: Array<IntArray>): Boolean {
        val c = HashMap<Int, Int>(graph.size)
        val v = HashSet<Int>(graph.size)
        fun find(node: Int): Boolean{
            v.add(node)
            val t = c[node]
            for(i in graph[node]){
                if(t == c[i])return false
                t?.let{c[i] = -1 * it}
                if(!v.contains(i) && !find(i))return false    
            }
            return true
        }

        for(i in graph.indices){
            if(!v.contains(i) && !find(i))return false
        }
        return true
    }
}