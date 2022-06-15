package dynamicprogramming

fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int{
    val m = obstacleGrid.size
    val n = obstacleGrid[0].size
    val dp = Array(m){IntArray(n){-1} }
    fun dfs(i: Int, j: Int): Int{
        if(i >= m || j >= n) return 0
        if(i == m-1 && j == n-1){
            return if(dp[i][j] != 0)0 else 1
        }

        if(obstacleGrid[i][j] == 1)return 0
        if(dp[i][j] != -1){
            return dp[i][j]
        }
        dp[i][j] = dfs(i+1, j) + dfs(i, j+1)
        return dp[i][j]
    }
    val t = dfs(0, 0)
    dp.forEach{
        println(it.contentToString())
    }
    return t
}

fun main(){
    val ob = arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 1, 0),
        intArrayOf(0, 0, 0)
    )
    println(uniquePathsWithObstacles(ob))
}