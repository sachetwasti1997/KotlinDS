package Graphs

fun countComponents(n: Int, edges: Array<IntArray>): Int {
    val graph = HashMap<Int, ArrayList<Int>>(n)
    for (i in edges.indices){
        if (graph[edges[i][0]] == null)graph[edges[i][0]] = ArrayList()
        if (graph[edges[i][1]] == null)graph[edges[i][1]] = ArrayList()
        graph[edges[i][0]]?.add(edges[i][1])
        graph[edges[i][1]]?.add(edges[i][0])
    }
    val visited = HashSet<Int>(n)
    fun dfs(node: Int){
        visited.add(node)
        for (i in graph[node] ?: ArrayList()){
            if (!visited.contains(i)){
                dfs(i)
            }
        }
    }
    var res = 0
    fun dfsHelper(){
        for (i in graph){
            if (!visited.contains(i.key)){
                res ++
                dfs(i.key)
            }
        }
    }
    dfsHelper()
    return res
}

fun main(){
    val edges = arrayOf(
        intArrayOf(2,3),
        intArrayOf(1, 2),
        intArrayOf(1, 3)
    )
    println(countComponents(3, edges))
}