package dynamicprogramming

fun climbStairs(n: Int): Int {
    fun dfs(index: Int): Int{
        if (index == n){
            return 1
        }
        if (index > n){
            return 0
        }
        return dfs(index+1) + dfs(index+2)
    }

    return dfs(0)
}

fun main(){
    println(climbStairs(3))
}