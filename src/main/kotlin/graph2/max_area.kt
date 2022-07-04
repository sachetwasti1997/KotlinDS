package graph2

fun maxAreaOfIsland(grid: Array<IntArray>): Int {
    val r = grid.size
    val c = grid[0].size
    val directions = arrayOf(0 to 1, 1 to 0, -1 to 0, 0 to -1)
    fun calc_area(i: Int, j: Int): Int{
        if(i >= 0 && i < r && j >= 0 && j < c && grid[i][j] == 1){
            grid[i][j] = 0
            var res = 1
            for(d in directions)res += calc_area(i+d.first, j+d.second)
        }
        return 0
    }
    var res = 0
    for(i in 0 until r){
        for(j in 0 until c){
            if(grid[i][j] == 0)res = Math.max(res, calc_area(i, j))
        }
    }
    return res
}