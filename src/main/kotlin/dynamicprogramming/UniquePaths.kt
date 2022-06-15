package dynamicprogramming

fun uniquePaths(m: Int, n: Int): Int {
    val dp = Array(m){IntArray(n){-1}}
    fun dfs(i: Int, j: Int):Int{
        if(i >= m || j >= n)return 0
        if(i == m-1 && j == n-1)return 1
        if(dp[i][j] != -1){
            return dp[i][j]
        }
        dp[i][j] = dfs(i+1, j)+dfs(i, j+1)
        return dp[i][j]
    }
    val t = dfs(0, 0)
    dp.forEach{
        println(it.contentToString())
    }
    return t
}

fun main(){
    println(uniquePaths(3, 7))
}