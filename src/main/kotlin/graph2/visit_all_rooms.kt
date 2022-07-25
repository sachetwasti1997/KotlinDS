class Solution {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val visit = HashSet<Int>(rooms.size)
        fun dfs(node: Int){
            visit.add(node)
            for(i in rooms[node]){
                if(!visit.contains(node))dfs(i)
            }
        }       
        dfs(0)
        return visit.size == rooms.size
    }
}