package Graphs

fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val parent = IntArray(edges.size + 1){it}
        val rank = IntArray(edges.size + 1){1}
        val resArr = ArrayList<Pair<Int, Int>>(parent.size)

        fun find(node: Int):Int{
            if (parent[node] != node){
                parent[node] = find(parent[node])
            }
            return parent[node]
        }

        fun union(node1: Int, node2: Int): Boolean{
            val par1 = find(node1)
            val par2 = find(node2)
            if (par1 == par2) return false
            if (rank[par1] < rank[par2]){
                parent[par1] = par2
            }else if (rank[par1] > rank[par2]){
                parent[par2] = par1
            }else{
                parent[par2] = par1
                rank[par1] += rank[par2]
            }
            return true
        }

        for (i in edges.indices){
            if (!union(edges[i][0], edges[i][1])){
                resArr.add(Pair(edges[i][0], edges[i][1]))
            }
        }
        return intArrayOf(resArr[resArr.size - 1].first, resArr[resArr.size - 1].second)
    }

fun main(){
    val edges = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(2, 3),
        intArrayOf(3, 4),
        intArrayOf(1, 4),
        intArrayOf(1, 5)
    )
    println(findRedundantConnection(edges).contentToString())
}