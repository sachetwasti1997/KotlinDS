package graph2

class Solution221 {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val r = heights.size
        val c = heights[0].size
        val direction = arrayOf(1 to 0, 0 to 1, -1 to 0, 0 to -1)
        fun dfsMarkArr(i: Int, j: Int, prev: Int, ocean: Array<BooleanArray>){
            if(i >= 0 && i < r && j >= 0 && j < c && prev <= heights[i][j] && !ocean[i][j]){
                ocean[i][j] = true
                for(d in direction)dfsMarkArr(i+d.first, j+d.second, heights[i][j], ocean)
            }
        }
        val pacific = Array(r){BooleanArray(c)}
        val atlantic = Array(r){BooleanArray(c)}
        for(i in 0 until r){
            dfsMarkArr(i, 0, -1, pacific)
            dfsMarkArr(i, c - 1, -1, atlantic)
        }
        for(i in 0 until c){
            dfsMarkArr(0, i, -1, pacific)
            dfsMarkArr(r-1, i, -1, atlantic)
        }
        val res = mutableListOf<List<Int>>()
        for(i in 0 until r){
            for(j in 0 until c){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(listOf(i, j))
                }
            }
        }
        return res
    }
}

fun main(){
    val s = Solution221()
    val heights = arrayOf(
        intArrayOf(1,2,2,3,5),
        intArrayOf(3,2,3,4,4),
        intArrayOf(2,4,5,3,1),
        intArrayOf(6,7,1,4,5),
        intArrayOf(5,1,1,2,4)
    )
    val t = s.pacificAtlantic(heights)
    println(t)
}