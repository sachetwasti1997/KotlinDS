package Graphs

import java.util.PriorityQueue

data class Edge(var vertex: Int, var weight: Int)
data class Vertex(var node: Int, var minDistance: Int)
fun createAdjList(graph: HashMap<Int, ArrayList<Edge>>, times: Array<IntArray>){
    for (node in times){
        if (!graph.containsKey(node[0])){
            graph[node[0]] = ArrayList()
        }
        graph[node[0]]?.add(Edge(node[1], node[2]))
    }
}
fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
    val graph = HashMap<Int, ArrayList<Edge>>(n)
    val minDisMap = HashMap<Int, Vertex>(n)
    createAdjList(graph, times)
    for (i in 1 .. n){
        minDisMap[i] = Vertex(i, Int.MAX_VALUE)
    }
    val q = PriorityQueue<Vertex>(n){
        a,b -> a.minDistance-b.minDistance
    }
    minDisMap[k]?.minDistance = 0
    q.add(minDisMap[k])
    while (!q.isEmpty()){
        val temp = q.poll()
            for (i in graph[temp.node] ?: ArrayList()){
                if(temp.minDistance + i.weight < (minDisMap[i.vertex]?.minDistance ?: 0)){
                    minDisMap[i.vertex]?.minDistance = temp.minDistance + i.weight
                    q.add(minDisMap[i.vertex])
                }
            }
    }
    var max = Int.MIN_VALUE
    for(i in minDisMap){
        if (i.value.minDistance == Int.MAX_VALUE){
            return -1;
        }
        max = max.coerceAtLeast(i.value.minDistance)
    }
    return max;
}

fun main(){
    val arr = arrayOf(
        intArrayOf(2, 1, 1),
        intArrayOf(2, 3, 1),
        intArrayOf(3, 4, 1)
    )
    println(networkDelayTime(arr, 4, 2))
}