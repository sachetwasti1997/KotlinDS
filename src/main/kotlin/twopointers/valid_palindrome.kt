class Solution27 {
    fun isPalindrome(s: String): Boolean {
        val str = s.lowercase()
        val res = StringBuilder()
        for(i in str){
            if(i in 'a'..'z'){
                res.append(i)
            }
        }
        val r = res.toString()
        var i = 0
        var j = s.length - 1
        while(i <= j){
            if(r[i] != r[j])return false
            i++
            j--
        }
        return true
    }
}

fun main(){
    val s = Solution27()
    s.isPalindrome("A man, a plan, a canal: Panama")
}