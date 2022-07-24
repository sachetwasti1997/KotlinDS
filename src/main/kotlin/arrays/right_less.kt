class Solution {
    fun countSmallerTLE(nums: IntArray): List<Int> {
        val m = ArrayList<Int>(nums.size)
        repeat(nums.size)m.add(0)
        for(i in 0 until nums.size - 1){
            for(j in i+1 until nums.size){
                if(nums[i] > nums[j])m[i] += 1
            }
        }       
        return m
    }
    class hold_small_lar(var large: Int, var small: Int)
    fun countSmaller(nums: IntArray): List<Int> {
        val res = ArrayList<Int>(nums.size)
        val m = HashMap<Int, Int>(nums.size)
        repeat(nums.size-1){
            m[nums[i]] = 0
            res.add(0)
        }
        for(i in nums.size-2 until 0){
            if(nums[i] > nums[i+1]){
                m[nums[i]] = m[nums[i+1]]?.plus(1)
                m[nums[i]]?.let{res[i] = it}
            }
        }
        return res
    }
}