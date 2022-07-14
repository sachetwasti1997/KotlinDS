class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
       val map = HashMap<Int, Int>()
       for(i in 0 until nums){
        if(map[nums[i]] != null)return arrayOf(i, map[nums[i]]!!)
        map[target-nums[i]] = i
       } 
       return arrayOf<Int>()
    }
}