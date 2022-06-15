package dynamicprogramming

import java.util.*

fun ninjaTraining(n: Int, points: Array<IntArray>): Int{
    val arr = Array(n){IntArray(3){-1} }
    fun findMaxPoints(i: Int, j: Int): Int{
        if(i >= n){
            return 0
        }
        if(i == 0){
            var mx = Int.MIN_VALUE
            for(k in 0..2){
                    var temp = points[i][k]
                    temp += findMaxPoints(i+1, k)
                    mx = mx.coerceAtLeast(temp)
            }
            return mx
        }
        if(arr[i][j] != -1){
            return arr[i][j]
        }
        var max = Int.MIN_VALUE
        for(k in 0 .. 2){
            if(k != j){
                var temp = points[i][k]
                temp += findMaxPoints(i+1, k)
                max = max.coerceAtLeast(temp);
            }
        }
        arr[i][j] = max
        return max
    }

    val t = findMaxPoints(0, -1)
    arr.forEach{
        println(it.contentToString())
    }
    return t
}

fun main(){
    val arr = arrayOf(
        intArrayOf(10, 50, 1),
        intArrayOf(5, 100, 11)
    )
    println(ninjaTraining(2, arr))
}