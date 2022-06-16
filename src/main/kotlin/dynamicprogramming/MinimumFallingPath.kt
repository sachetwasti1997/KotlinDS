package dynamicprogramming


fun minFallingPathSum(matrix: Array<IntArray>): Int {
    val m = matrix.size
    val n = matrix[0].size
    val dp = Array(m){IntArray(n){-1}}
    fun dfs(i: Int, j: Int):Int{
        if(i == m || j == n || i == -1 || j == -1)return Int.MAX_VALUE
        if(i == 0){
            var mx = Int.MAX_VALUE
            for(it in 0 until n){
                val res = Math.min(dfs(1, it), Math.min(dfs(1, it+1), dfs(1, it-1)))
                val t = matrix[i][it] + if(res == Int.MAX_VALUE) 0 else res
                mx = Integer.min(mx, t)
            }
            return mx
        }
        if(dp[i][j] != -1)return dp[i][j]
        val res = Math.min(dfs(i+1, j), Math.min(dfs(i+1, j+1), dfs(i+1, j-1)))
        dp[i][j] = matrix[i][j] + if(res == Int.MAX_VALUE)0 else res
        return dp[i][j]
    }

    return dfs(0, 0)
}

fun main(){
    val arr = arrayOf(
        intArrayOf(17, 82),
        intArrayOf(1, -44)
    )
    println(minFallingPathSum(arr))
}