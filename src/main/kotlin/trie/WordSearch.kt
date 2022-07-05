package trie

class TrieNode(val child: HashMap<Char, TrieNode> = HashMap(), var isEnd: Boolean = false, var word: String = "")
fun insert(temp: TrieNode, word:String){
    var root = temp
    word.forEach{i ->
        if(root.child[i] == null)root.child[i] = TrieNode()
        root = root.child[i]!!
    }
    root.isEnd = true
    root.word = word
}
fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
    val r = board.size; val c = board[0].size;
    val direction = arrayOf(1 to 0, 0 to 1, -1 to 0, 0 to -1)
    val res = mutableSetOf<String>()
    val visit = HashSet<String>()
    fun find(i: Int, j: Int, root: TrieNode){
        if(root.isEnd){
            res.add(root.word)
        }
        val key = "$i $j"
        if(i < 0 || i >= r || j < 0 || j >= c || root.child[board[i][j]] == null || visit.contains(key))return
        val temp = board[i][j]
        visit.add(key)
        for(d in direction){
            val row = i + d.first
            val col = j + d.second
            find(row, col, root.child[temp]!!)
        }
        visit.remove(key)
    }
    val root = TrieNode()
    for(i in words)insert(root, i)
    for(i in board.indices){
        for(j in board[0].indices){
            find(i, j, root)
        }
    }
    return res.toList()
}

fun main(){
    val board = arrayOf(
        charArrayOf('o', 'a', 'b', 'n'),
        charArrayOf('o', 't', 'a', 'e'),
        charArrayOf('a', 'h', 'k', 'r'),
        charArrayOf('a', 'f', 'l', 'v')
    )
    val words = arrayOf("oa", "oaa")
    println(findWords(board, words))

    board.forEach {
        println(it.contentToString())
    }
}















