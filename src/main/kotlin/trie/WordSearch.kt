package trie

import java.util.Arrays

data class TrieNode(val children: HashMap<Char, TrieNode> = HashMap(),
               var isEnd: Boolean = false,
               var word: String ?= null)

fun insert(root: TrieNode, word: String){
    var temp = root
    var n = 0
    word.forEach {
        if (temp.children[it] == null){
            temp.children[it] = TrieNode()
        }
        temp = temp.children[it] ?: TrieNode()
    }
    temp.isEnd = true
    temp.word = word
}

fun findWords(board: Array<CharArray>, words: Array<String>): List<String>{
    val root = TrieNode()
    val R = board.size
    val C = board[0].size
    val resList = ArrayList<String>()
    words.forEach {
        insert(root, it)
    }
    println(root)
    val dirArr = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1))
    fun findWord(i: Int, j:Int, root: TrieNode?){
        if (root == null){
            return
        }
        if (i < 0 || j < 0 || i >= R || j >= C || root.children[board[i][j]] == null){
            return
        }
            if (root.isEnd){
                resList.add(root.word ?: "")
                println("$i $j")
            }
            val temp = board[i][j]
            board[i][j] = ' '
            for (dir in dirArr){
                findWord(i+dir[0], j+dir[1], root.children[temp])
            }
            board[i][j] = temp
    }
    for (i in board.indices){
        for (j in board[0].indices){
            findWord(i, j, root)
        }
    }
    return  resList.toList()
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















