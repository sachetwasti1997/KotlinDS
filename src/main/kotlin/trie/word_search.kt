package trie

class WordDictionary(var charMap: HashMap<Char, WordDictionary> = HashMap(), var isEnd: Boolean = false) {

    fun addWord(word: String) {
        var temp = this
        word.forEach{
            if(temp.charMap[it] == null)temp.charMap[it] = WordDictionary()
            temp = temp.charMap[it]!!
        }
        temp.isEnd = true
    }

    fun search(word: String): Boolean {
        fun searchRec(root: WordDictionary, ind: Int): Boolean {
            if(ind == word.length){
                return root.isEnd
            }
            if(word[ind] != '.'){
                if(root.charMap[word[ind]] == null)return false
                return searchRec(root.charMap[word[ind]]!!, ind + 1)
            }else{
                var b = false
                for(k in root.charMap){
                    b = b || searchRec(root.charMap[k.key]!!, ind+1)
                }
                return b
            }
        }
        return searchRec(this, 0)
    }

}