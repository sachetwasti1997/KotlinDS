package Graphs

import java.util.LinkedList
import java.util.Queue

fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
    if (!wordList.contains(endWord)) return 0
    val t = beginWord.length
    val patterWordList = HashMap<String, ArrayList<String>>(wordList.size * t)
    for (i in wordList.indices){
        for (j in wordList[i].indices){
            val pattern = wordList[i].slice(IntRange(0, j-1)) + "*" + wordList[i].slice(IntRange(j+1, wordList[i].length-1))
            if (!patterWordList.containsKey(pattern)){
                patterWordList[pattern] = ArrayList()
            }
            patterWordList[pattern]?.add(wordList[i])
        }
    }
    println(patterWordList)
    val visited = HashSet<String>()
    var res = 1
    visited.add(beginWord)
    val q: Queue<String> = LinkedList()
    q.add(beginWord)
    while (!q.isEmpty()){
        for (i in q.indices){
            val r = q.poll()
            if (r == endWord)return res
            for (i1 in r.indices){
                val pattern = r.slice(IntRange(0, i1-1)) +"*"+ r.slice(IntRange(i1+1, r.length-1))
                for (words in patterWordList[pattern] ?: emptyList()){
                    if (!visited.contains(words)){
                        visited.add(words)
                        q.add(words)
                    }
                }
            }
        }
        res ++
    }
    return 0
}

fun main(){
    println(ladderLength("hit", "cog", listOf("hot","dot","dog","lot","log","cog")))
}