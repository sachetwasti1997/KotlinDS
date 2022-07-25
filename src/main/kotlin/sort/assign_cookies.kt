class Solution {
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        if(s.size == 0)return 0
        g.sortWith{x,y -> y.compareTo(x)}
        s.sortWith{x,y -> y.compareTo(x)}
        var i = 0
        var j = 0
        var content = 0
        while(i < g.size && j < s.size){
            when{
                g[i] <= s[j] -> {
                    content++
                    i++
                    j++
                }
                g[i] > s[j] -> {
                    i++
                }
            }
        }  
        return content     
    }
}