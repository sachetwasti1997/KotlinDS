package sliding_window

fun minWindow(s: String, t: String): String {
    val required = HashMap<Char, Int>(t.length)
    for (i in t){
        if (i in required)required[i] = required[i]!! + 1
        else required[i] = 1
    }
    val window = HashMap<Char, Int>(t.length)
    var resI = 0
    var resJ = 0
    var have = 0
    var max = Int.MAX_VALUE
    var i = 0
    var j = 0
    while(i < s.length && j < s.length){
        if (required.containsKey(s[j])){
            if (!window.containsKey(s[j])){
                window[s[j]] = 1
            }else{
                window[s[j]] = window[s[j]]?.plus(1) ?: 0
            }
            if ((window[s[j]] ?: 0) <= (required[s[j]] ?: 0)){
                have ++
            }
            if (have == t.length){
                if (j - i + 1 < max){
                    resI = i
                    resJ = j
                    max = j-i+1
                }
            }
        }
        while (have == t.length){
            if (required.containsKey(s[i])){
                if ((window[s[i]]?.compareTo(0) ?: 0) > 0){
                    window[s[i]] = window[s[i]]?.minus(1) ?: 0
                    if ((window[s[i]] ?: 0) < (required[s[i]] ?: 0)){
                        have --
                        if (max > j - i + 1){
                            resI = i
                            resJ = j
                            max = j - i + 1
                        }
                        i++
                        break
                    }
                }
            }else if (j - i + 1 < max){
                resI = i
                resJ = j
                max = j-i+1
            }
            i++
        }
        j++
    }
    if(max == Int.MAX_VALUE)return ""
    return s.slice(IntRange(resI, resJ))
}

fun main(){
    println(minWindow("ADOBECODEBANC", "ABC"))
}
