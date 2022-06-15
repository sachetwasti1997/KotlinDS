package dynamicprogramming

fun minimumTotal(triangle: List<List<Int>>): Int {
    val n = triangle.size
    val dp = Array(n){IntArray(n){-1}}
    fun dfs(i: Int, j: Int): Int{
        if(j >= n) return 0
        if(dp[j][i] != -1) return dp[j][i]
        val temp = triangle[j][i]
        dp[j][i] = temp + Math.min(dfs(i, j + 1), dfs(i + 1, j + 1))
        return dp[j][i]
    }
    return dfs(0, 0)
}

fun main(){
    val tri = listOf(
        listOf(2),
        listOf(3, 4),
        listOf(6, 5, 7),
        listOf(4, 1, 8, 3)
    )
    println(minimumTotal(tri))
}