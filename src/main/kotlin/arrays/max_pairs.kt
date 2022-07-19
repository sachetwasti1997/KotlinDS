class Solution {
    fun numberOfPairs(nums: IntArray): IntArray {
        val m = HashMap<Int, Int>(nums.size)
        for(i in nums){
            m[i] = m[i]?.plus(1) ?: 1
        }       
        var p = 0
        var r = 0
        for(i in m){
            p += i / 2
            r += i % 2
        }
        return intArrayOf(p, r)
    }
}