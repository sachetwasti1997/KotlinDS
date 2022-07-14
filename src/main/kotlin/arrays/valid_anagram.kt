class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val set = HashMap<Char, Int>()
        for(i in s){
            if(set[i] == null)set[i] = 1
            else set[i] = set[i]!! + 1
        }
        for(i in t){
            if(set[i] == null)return false
            set[i] = set[i]!! - 1
            if(set[i] == 0)set.remove(i)
        }
        return set.size == 0
    }
}

fun main(){
    val s = Solution25()
    s.isAnagram("ab", "a")
}