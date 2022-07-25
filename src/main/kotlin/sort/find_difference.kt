class Solution {
    fun findTheDifference(s: String, t: String): Char {
        val sm = HashMap<Char, Int>(s.length)
        for(i in s)sm[i] = sm[i]?.plus(1) ?: 1
        for(i in t){
            sm[i] = sm[i]?.minus(1) ?: 1
        }    
        for(i in sm){
            if(i.value != 0)return i.key
        }
        return 'a'
    }
    fun findTheDifference(s: String, t: String) : Char {
        var code = 0
        for(i in s){
            code = code xor i.code
        }
        for(i in t){
            code = code xor i.code
        }
        return Char(code)
    }
}