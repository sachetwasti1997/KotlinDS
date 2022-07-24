class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        var rowStart = 0
        var rowEnd = martrix.size-1
        val colStart = 0
        var colEnd = matrix[0].size-1
        val res = ArrayList<Int>()
        while(rowStart <= rowEnd && colStart <= colEnd){
            for(i in colStart .. colEnd)res.add(matrix[rowStart][i])
            rowStart++
            for(i in rowStart .. rowEnd)res.add(matrix[i][colEnd])
            colEnd--
            for(i in colEnd downTo colStart)res.add(matrix[rowEnd][i])
            rowEnd--
            for(i in rowEnd downTo rowStart)res.add(matrix[i][colStart])
            colStart++
        }       
        return res
    }
}