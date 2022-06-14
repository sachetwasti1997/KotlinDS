package string

fun isAnagram(s: String, t: String): Boolean{
    if (s.length != t.length)return false
    var freqMap = HashMap<Char, Int>(s.length)
    s.forEach {
        if (freqMap[it] == null) freqMap[it] = 1
        else freqMap[it] = (freqMap[it]?.plus(1)) ?: 0
    }
    t.forEach {
        if (freqMap[it] == null)return false
        else freqMap[it] = freqMap[it]?.minus(1) ?: 0
    }
    freqMap.forEach {
        if (it.value != 0)return false
    }
    return true
}

fun main(){
    println(isAnagram("ratt", "tatr"))
}