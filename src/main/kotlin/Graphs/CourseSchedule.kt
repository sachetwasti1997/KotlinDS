package Graphs

fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean{
    val graph = HashMap<Int, ArrayList<Int>>(numCourses)
    for (i in prerequisites.indices){
        if (!graph.containsKey(prerequisites[i][0])) graph[prerequisites[i][0]] = ArrayList()
        graph[prerequisites[i][0]]?.add(prerequisites[i][1])
    }
    val visited = HashSet<Int>(numCourses)
    val isBeingVisited = HashSet<Int>(numCourses)

    fun hasCycle(node: Int):Boolean{
        visited.add(node)
        isBeingVisited.add(node)
        for (i in graph[node] ?: emptyList()){
            if (!visited.contains(i) && hasCycle(i)){
                return true
            }
            if (isBeingVisited.contains(i)){
                return true;
            }
        }
        isBeingVisited.remove(node)
        return false
    }

    for (i in 0 until numCourses){
        if (!visited.contains(i)){
            if (hasCycle(i))return false
        }
    }

    return true
}
fun main(){
    val preRequisite = arrayOf(
        intArrayOf(2, 0),
        intArrayOf(1, 0),
        intArrayOf(3, 1),
        intArrayOf(3, 2),
        intArrayOf(1, 3)
    )
    val t = canFinish(4, preRequisite)
    print(t)
}