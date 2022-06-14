package Graphs

import java.util.LinkedList
import java.util.PriorityQueue

data class EdgeMSP(var v1: String, var v2: String, var weight: Int)

fun PrimsJarNik(edges: Array<Array<String>>){
    val graph = HashMap<String, ArrayList<EdgeMSP>>()
    edges.forEach {
        if (graph[it[0]] == null){
            graph[it[0]] = ArrayList()
        }
        graph[it[0]]?.add(EdgeMSP(it[0], it[1], it[2].toInt()))
    }
    println(graph)
    val unvisited = HashSet<String>(graph.keys)
    val resList = ArrayList<String>()
    var totalCost:Int = 0

    fun bfs(node: String){
        val q = PriorityQueue<EdgeMSP>(){
            a,b -> a.weight - b.weight
        }
        var node1 = node
        unvisited.remove(node)
        while (unvisited.isNotEmpty()){
            for (e in graph[node1] ?: ArrayList()){
                if (unvisited.contains(e.v2)){
                    q.add(e)
                }
            }
            val temp = q.poll()
            if (!unvisited.contains(temp.v2))continue
            resList.add("${temp.v1} ${temp.v2}")
            totalCost += temp.weight.toInt()
            node1 = temp.v2
            unvisited.remove(node1)
        }
    }
    for (i in graph.keys){
        if (unvisited.contains(i))bfs(i)
    }
    println(resList)
    println(totalCost)
}

fun main(){
    val nodesWeights = arrayOf(
        arrayOf("A", "B", "1"),
        arrayOf("A", "D", "12"),
        arrayOf("A", "C", "2"),

        arrayOf("C", "F", "3"),
        arrayOf("C", "D", "6"),
        arrayOf("C", "A", "2"),

        arrayOf("B", "E", "7"),
        arrayOf("B", "D", "4"),
        arrayOf("B", "A", "1"),
        arrayOf("B", "G", "8"),

        arrayOf("D", "E", "2"),
        arrayOf("D", "B", "4"),
        arrayOf("D", "A", "12"),
        arrayOf("D", "C", "6"),
        arrayOf("D", "F", "5"),

        arrayOf("E", "B", "7"),
        arrayOf("E", "D", "2"),
        arrayOf("E", "F", "4"),
        arrayOf("E", "G", "9"),

        arrayOf("F", "C", "3"),
        arrayOf("F", "D", "5"),
        arrayOf("F", "E", "4"),
        arrayOf("F", "G", "2"),

        arrayOf("G", "F", "2"),
        arrayOf("G", "E", "9"),
        arrayOf("G", "B", "8"),
    )
    PrimsJarNik(nodesWeights)
}