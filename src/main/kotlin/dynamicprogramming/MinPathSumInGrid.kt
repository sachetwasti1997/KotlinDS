package dynamicprogramming

fun minPathSum(grid: Array<IntArray>): Int {
    val m = grid.size - 1
    val n = grid[0].size - 1
    val dp = Array(m+1){IntArray(n+1){-1}}
    fun dfs(i: Int, j: Int): Int{
        if(i == m && j == n) return grid[i][j]
        if(i > m || j > n) return Int.MAX_VALUE
        if(dp[i][j] != -1){
            return dp[i][j]
        }
        dp[i][j] = grid[i][j] + dfs(i + 1, j).coerceAtMost(dfs(i, j + 1))
        return dp[i][j]
    }
    return dfs(0, 0)
}

fun main(){
    val grid = arrayOf(
        intArrayOf(1,3,1),
        intArrayOf(1,5,1),
        intArrayOf(4,2,1)
    )
    println(minPathSum(grid))
}