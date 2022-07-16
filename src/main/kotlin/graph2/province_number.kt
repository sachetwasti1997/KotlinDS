class Solution {
    fun findCircleNum(isConnected: Array<IntArray>): Int {
        val n = isConnected.size
        val ust = IntArray(n){i -> i}
        val rnk = IntArray(n){1}
        fun find(x: Int):Int{
            if(ust[x] != x){
                ust[x] = find(ust[x])
            }
            return ust[x]
        }
        fun insert(x: Int, y: Int){
            val parX = find(x)
            val parY = find(y)
            if(parX == parY)return
            if(rnk[parX] > rnk[parY])ust[parY] = parX
            else if(rnk[parX] < rnk[parY])ust[parX] = parY
            else{
                ust[parY] = parX
                rank[parX] += 1
            }
        }
        for(i in 0 until n){
            for(j in 0 until n){
                if(i == j)continue
                if(isConnected[i][j] == 1)insert(i, j)
            }
        }
        var res = 0
        for(i in 1 until ust.size){
            if(ust[i-1] != ust[i])res ++
        }
        return res
    }
}