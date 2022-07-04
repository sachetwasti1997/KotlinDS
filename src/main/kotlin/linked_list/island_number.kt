package linked_list

fun numIslands(grid: Array<CharArray>): Int {
    val r = grid.size
    val c = grid[0].size
    val direction = arrayOf(0 to 1, 1 to 0, -1 to 0, 0 to -1)
    fun dfsCount(i: Int, j: Int){
        if(i in 0 until r && j in 0 until c && grid[i][j] == '1'){
            grid[i][j] = '0'
            for(d in direction){
                dfsCount(i+d.first, j+d.second)
            }
        }
    }
    var count = 0
    for(i in 0 until r){
        for(j in 0 until c){
            if(grid[i][j] == '1'){
                count++
                dfsCount(i, j)
            }
        }
    }
    return count
}