package Graphs

import java.util.PriorityQueue

//Kruskal's Algorithm
class MinimumSpanningTree {
    data class Edges(var weight: Int, val vertex1: Char, val vertex2: Char)
    private val graph = HashMap<Char, ArrayList<Edges>>()
    private val visited = HashSet<String>()
    private val pq = PriorityQueue<Edges>(){
        a,b -> a.weight - b.weight
    }
    private val disjointSet = HashMap<Char?, Char?>()
    private val rank = HashMap<Char?, Int>()
    private val resList = ArrayList<String>()

    private fun createQueue(){
        graph.forEach {
            for (i in it.value){
                if (visited.contains("${i.vertex1} ${i.vertex2}") || visited.contains("${i.vertex2} ${i.vertex1}")){
                    continue
                }
                visited.add("${i.vertex1} ${i.vertex2}")
                pq.add(i)
                disjointSet[i.vertex1] = i.vertex1
                disjointSet[i.vertex2] = i.vertex2
                rank[i.vertex1] = 1
                rank[i.vertex2] = 1
            }
        }
    }

    private fun find(v1: Char): Char? {
        if (v1 != disjointSet[v1]){
            disjointSet[v1] = find(disjointSet[v1] ?: v1)
        }
        return disjointSet[v1]
    }

    private fun union(v1: Char, v2: Char): Boolean{
        val par1 = find(v1)
        val par2 = find(v2)
        if (par1 == par2){
            return false
        }
        if ((rank[par1] ?: 1) > (rank[par2] ?: 1)){
            disjointSet[par2] = par1
        }else if ((rank[par2] ?: 1) > (rank[par1] ?: 1)){
            disjointSet[par1] = par2
        }else{
            rank[par1] = rank[par1]?.plus(rank[par2]?:1) ?: 1
            disjointSet[par2] = par1
        }
        return true
    }

    fun createAdjList(){
        graph['A'] = ArrayList()
        graph['A']?.add(Edges(2, 'A', 'B'))
        graph['A']?.add(Edges(5, 'A', 'E'))
        graph['A']?.add(Edges(6, 'A', 'C'))
        graph['A']?.add(Edges(10, 'A', 'F'))

        graph['B'] = ArrayList()
        graph['B']?.add(Edges(2, 'B', 'A'))
        graph['B']?.add(Edges(3, 'B', 'D'))
        graph['B']?.add(Edges(3, 'B', 'E'))

        graph['C'] = ArrayList()
        graph['C']?.add(Edges(6, 'C', 'A'))
        graph['C']?.add(Edges(2, 'C', 'F'))
        graph['C']?.add(Edges(1, 'C', 'D'))

        graph['D'] = ArrayList()
        graph['D']?.add(Edges(5, 'D', 'G'))
        graph['D']?.add(Edges(4, 'D', 'E'))
        graph['D']?.add(Edges(1, 'D', 'C'))
        graph['D']?.add(Edges(3, 'D', 'B'))

        graph['E'] = ArrayList()
        graph['E']?.add(Edges(5, 'E', 'A'))
        graph['E']?.add(Edges(4, 'E', 'D'))
        graph['E']?.add(Edges(3, 'E', 'B'))

        graph['F'] = ArrayList()
        graph['F']?.add(Edges(10, 'F', 'A'))
        graph['F']?.add(Edges(5, 'F', 'G'))
        graph['F']?.add(Edges(2, 'F', 'C'))

        graph['G'] = ArrayList()
        graph['G']?.add(Edges(5, 'G', 'D'))
        graph['G']?.add(Edges(5, 'G', 'F'))

        createQueue()
        println(graph)
        println(pq.peek())
        var totalCost = 0
        while (!pq.isEmpty()){
            val i = pq.poll()
            if (union(i.vertex1, i.vertex2)){
                resList.add("${i.vertex1} ${i.vertex2}")
                totalCost += i.weight
            }
        }
        println(disjointSet)
        println(rank)
        println(resList)
        println(totalCost)
    }

}
fun main(){
    val spTree = MinimumSpanningTree()
    spTree.createAdjList()
}