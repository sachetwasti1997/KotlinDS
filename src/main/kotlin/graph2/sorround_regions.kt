package graph2

class SRegions{
    fun solve(board: Array<CharArray>): Unit {
        val r = board.size
        val c = board[0].size
        val direction = arrayOf(1 to 0, 0 to 1, -1 to 0, 0 to -1)
        fun dfs(i: Int, j: Int){
            if(i >= 0 && i < r && j >= 0 && j < c && board[i][j] == 'O'){
                board[i][j] = 'T'
                for(d in direction)dfs(i+d.first, j+d.second)
            }
        }
        for(i in 0 until r){
            for(j in 0 until c){
                if(i == 0 || i == r-1 || j == 0 || j==c-1)dfs(i, j)
            }
        }
        for(i in 0 until r){
            for(j in 0 until c) {
                if(board[i][j] == 'O')board[i][j] = 'X'
                else if(board[i][j] == 'T')board[i][j] = 'O'
            }
        }
    }
}