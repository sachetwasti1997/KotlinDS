package Graphs

data class Graph(var data: Int ?= null, var list: MutableList<Graph> ?= null)

fun main(){
    val array = MutableList<Int>(10){0}
    array[0] = 1
    println(array)
    val arrayGraph = MutableList<Graph>(10){Graph(-1)}
    arrayGraph.add(Graph())
    arrayGraph[0] = Graph()
    arrayGraph[0].data = 1
    arrayGraph[0].list = MutableList(10){Graph()}
    println(arrayGraph[0])
    val map = HashMap<Int, ArrayList<Int>>(20)
    map.put(1, ArrayList(10))
    map[1]?.add(1)
    println(map)
}