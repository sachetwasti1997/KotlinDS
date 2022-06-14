package Graphs

import java.util.LinkedList

class IndicesTime(val i: Int, val j: Int, val time: Int)

fun orangesRotting(grid: Array<IntArray>): Int{
    val q = LinkedList<IndicesTime>()
    val R = grid.size
    val C = grid[0].size
    var oneCount = 0
    for (i in 0 until R){
        for (j in 0 until C){
            if (grid[i][j] == 2){
                q.add(IndicesTime(i, j, 0))
            }else if (grid[i][j] == 1) {
                oneCount ++
            }
        }
    }
    val dirArr = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1))
    var maxTime = Int.MIN_VALUE
    while (!q.isEmpty()){
        val temp = q.removeFirst()
        for (i in dirArr){
            val r = temp.i + i[0]
            val c = temp.j + i[1]
            maxTime = Math.max(maxTime, temp.time)
            if (r >= 0 && c >= 0 && r < R && c < C && grid[r][c] == 1){
                grid[r][c] = 2
                q.add(IndicesTime(r, c, temp.time + 1))
                oneCount --
            }
        }
    }
    if (oneCount != 0) return -1
    return maxTime
}

fun main(){
    val grid = arrayOf(
        intArrayOf(2, 1, 1),
        intArrayOf(1, 1, 0),
        intArrayOf(0, 1, 1)
    )
    println(orangesRotting(grid))
}