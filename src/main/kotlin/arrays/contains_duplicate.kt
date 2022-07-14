class Solution23 {
    fun containsDuplicate(nums: IntArray): Boolean {
        val mp = HashSet<Int>()
        for(i in nums){
            if(mp.contains(i))return true
        }       
        return false 
    }
}

fun main(){
    val t = intArrayOf(1, 2, 3, 1)
    val s = Solution23()
    s.containsDuplicate(t)
}