class Solution {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        val g = HashMap<Int, ArrayList<Int>>()
        for(i in trust){
            if(g[i[0]] == null)g[i[0]] = ArrayList()
            g[i[0]]?.add(i[1])
        }       
        val v = HashSet<Int>(n)
        val bv = HashSet<Int>(n)
        val res = ArrayList<Int>(n)
        fun cycle(n: Int): Boolean{
            v.add(n)
            bv.add(n)
            for(i in g[n].orEmpty()){
                if(!v.contains(i) && dfs(i))return true
                if(bv.contains(i))return true
            }
            bv.remove(n)
            res.add(n)
            return false
        }
        if(cycle(trust[0][0]))return -1
        return res[0]
    }
}