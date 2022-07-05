package trie

class Trie {
    val charMap = HashMap<Char, TrieNode>()
    var isEnd = false

    fun insert(word: String) {
        var temp = this
        for(i in word){
            if(temp.charMap[i] == null){
                temp.charMap[i] = TrieNode()
            }
            temp = temp.charMap[i]!!
        }
        temp.isEnd = true
    }

    fun search(word: String): Boolean {
        var temp = this
        for(i in word){
            if(temp.charMap[i] == null)return false
            temp = temp.charMap[i]!!
        }
        return temp.isEnd
    }

    fun startsWith(prefix: String): Boolean {
        var temp = this
        for(i in prefix){
            if(temp.charMap[i] == null)return false
            temp = temp.charMap[i]!!
        }
        return true
    }
}