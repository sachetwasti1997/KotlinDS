package hashset

class Solution22 {
    fun intToRoman(num: Int): String {
        val valMap = mapOf(1 to "I", 4 to "IV", 5 to "V",
            9 to "IX", 10 to "X", 40 to "XL", 50 to "L",
            90 to "XC", 100 to "C", 400 to "CD",
            500 to "D", 900 to "CM", 1000 to "M")
        var n = num
        var res = ""
        while(n > 0){
            var nm = 1
            for(i in valMap){
                if(i.key > n)break
                nm = i.key
            }
            res += valMap[nm]
            n -= nm
        }
        return res
    }
}

fun main(){
   val s = Solution22()
    val n = s.intToRoman(1994)
    print(n)
}