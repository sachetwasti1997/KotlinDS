package graph2

    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        if(prerequisites.size == 0)return IntArray(numCourses){i -> i}
        val graph = HashMap<Int, ArrayList<Int>>()
        for(i in 0 until numCourses)graph[i] = ArrayList()

        val res = IntArray(numCourses)
        var k = 0
        val visited = HashSet<Int>(numCourses)
        val beingvisit = HashSet<Int>(numCourses)
        fun hasCycle(node: Int):Boolean{
            visited.add(node)
            beingvisit.add(node)
            for(i in graph[node].orEmpty()){
                if(!visited.contains(i) && hasCycle(i))return true
                else if(beingvisit.contains(i))return true
            }
            res[k++] = node
            beingvisit.remove(node)
            return false
        }

        for(i in prerequisites)graph[i[0]]?.add(i[1])
        for(i in graph){
            if(!visited.contains(i.key) && hasCycle(i.key))return intArrayOf()
        }
        return res
    }