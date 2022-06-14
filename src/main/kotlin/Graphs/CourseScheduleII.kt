package Graphs

import java.util.Stack

fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray{
    if (numCourses == 1){
        return IntArray(1){0}
    }else if(prerequisites.size == 0){
        return IntArray(numCourses){i -> i}
    }
    val graph = HashMap<Int, ArrayList<Int>>(numCourses)
    for (i in prerequisites.indices){
        if (!graph.containsKey(prerequisites[i][0]))graph[prerequisites[i][0]] = ArrayList()
        graph[prerequisites[i][0]]?.add(prerequisites[i][1])
    }
    val visited = HashSet<Int>(numCourses)
    val isBeingVisited = HashSet<Int>(numCourses)
    val topologicalSort = Stack<Int>()

    fun isNotPossibleToFinishCourse(node: Int): Boolean{
        visited.add(node)
        isBeingVisited.add(node)
        for (i in graph[node] ?: ArrayList()){
            if (!visited.contains(i) && isNotPossibleToFinishCourse(i)){
                return true
            }
            if (isBeingVisited.contains(i))return true
        }
        isBeingVisited.remove(node)
        return false
    }

    fun sort(node: Int){
        visited.add(node)
        for (i in graph[node] ?: ArrayList()){
            if (!visited.contains(i)){
                sort(i)
            }
        }
        topologicalSort.add(node)
    }

    for (i in 0 until numCourses){
        if (isNotPossibleToFinishCourse(i))return IntArray(0)
    }
    visited.clear()
    val resArr = IntArray(numCourses)
    for (i in 0 until numCourses){
        if (!visited.contains(i))sort(i)
    }
    var k = topologicalSort.size - 1
    var t = topologicalSort.size
    while (k >= 0){
        resArr[k--] = topologicalSort.pop()
    }
    if (t < numCourses){
        for (i in t until numCourses){
            resArr[t++] = i
        }
    }
    return resArr
}