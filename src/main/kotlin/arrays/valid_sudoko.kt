class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val row = IntArray<HashSet<Int>>(9)
        val col = IntArray<HashSet<Int>>(9)
        val sq = HashMap<String, HashSet<String>>(9)
        for(i in 0 until board.size){
            for(j in 0 until board[0].size){
                if(!row[i].contains(board[i][j]))row[i].add(board[i][j])
                else return false
                if(!col[j].contains(board[i][j]))col[j].add(board[i][j])
                else return false
                val key = "$(i/3) $(j/3)"
                if(sq[key] == null)sq[key] = board[i][j]
                else return false
            }
        }
        return true
    }
}