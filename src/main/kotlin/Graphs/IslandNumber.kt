package Graphs

import java.util.*

class PairInt(val i: Int, val j: Int)

fun numIslands(edges: Array<CharArray>): Int{
    var resNum = 0
    val R = edges.size
    val C = edges[0].size
    val dirArr = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1))
    fun bfs(i: Int, j: Int){
        val q = LinkedList<PairInt>()
        q.add(PairInt(i, j))
        edges[i][j] = '2'
        while (!q.isEmpty()){
            val t = q.removeFirst()
            for (it in dirArr){
                val row = t.i + it[0]
                val col = t.j + it[1]
                if (row >= 0 && col >= 0 && col < C && row < R && edges[row][col] == '1'){
                    q.add(PairInt(row, col))
                    edges[row][col] = '2'
                }
            }
        }
    }

    fun dfs(i: Int, j: Int){
        if (i >= 0 && j >= 0 && i < R && j < C && edges[i][j] == '1'){
            edges[i][j] = '2'
            for (it in dirArr){
                dfs(i+it[0], j+it[1])
            }
        }
    }

    for (i in 0 until R){
        for (j in 0 until C){
             if (edges[i][j] == '1'){
                 resNum++
                 bfs(i, j)
             }
        }
    }

    return resNum
}

fun main(){
    val grid = arrayOf(
        charArrayOf('1', '1', '1', '1', '0'),
        charArrayOf('1', '1', '0', '1', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '0', '1', '1')
    )
    println(numIslands(grid))
}