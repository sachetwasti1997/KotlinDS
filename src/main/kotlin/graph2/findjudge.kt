class Solution {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        class InOut(var incmg: Int, var outgng: Int)
        val g = HashMap<Int, InOut>(n)
        for(i in 1 .. n)g[i] = InOut(0,0)
        for(i in trust){
            g[i[0]]!!.outgng += 1
            g[i[1]]!!.incmg += 1 
        }
        for(i in g){
            if(i.value.incmg == n-1 && i.value.outgng == 0)return i.key
        }       
        return -1
    }
}