class Solution {
    fun digitCount(num: String): Boolean {
        if(num.length == 1){
            if(num[0] == '1')return true
            else return false
        }       
        val m = HashMap<Int, Int>()
        for(i in num)m[i] = m[i]?.plus(1) ?: 1
        for(i in num.indices){
            if(m[i.toChar()] != num[i].digitToInt())return false
        }
        return true
    }
}