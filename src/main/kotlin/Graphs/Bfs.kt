package Graphs

import java.util.LinkedList
import java.util.Queue

fun bfs(){
    val graph = HashMap<Int, HashSet<Int>>()
    graph[0] = HashSet()
    graph[0]?.add(1)
    graph[0]?.add(2)
    graph[0]?.add(5)
    graph[2] = HashSet()
    graph[2]?.add(0)
    graph[2]?.add(4)
    graph[1] = HashSet()
    graph[1]?.add(0)
    graph[1]?.add(3)
    graph[3] = HashSet()
    graph[3]?.add(1)
    graph[3]?.add(5)
    graph[5] = HashSet()
    graph[5]?.add(0)
    graph[5]?.add(3)
    graph[5]?.add(4)
    graph[4] = HashSet()
    graph[4]?.add(2)
    graph[4]?.add(5)
    println(graph)
    fun traverse(){
        val visited = HashSet<Int>()
        val que: Queue<Int> = LinkedList()
        que.add(0)
        visited.add(0)
        while (!que.isEmpty()){
            val temp = que.poll()
            print("$temp ")
            for (t in graph[temp] ?: emptyList()){
                if (!visited.contains(t)){
                    que.add(t)
                    visited.add(t)
                }
            }
        }
    }
    traverse()
}

fun main(){
    bfs()
}