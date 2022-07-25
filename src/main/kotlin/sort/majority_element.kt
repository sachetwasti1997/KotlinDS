class Solution {
    fun majorityElement(nums: IntArray): Int {
        nums.sort()
        var i = 1
        var max = 1
        var res = nums[0]
        while(i < nums.size){
            var temp = 1
            while(i < nums.size && nums[i] == nums[i-1]){
                temp++
                i++
            }
            if(temp > max){
                max = temp
                res = nums[i-1]
            }
            i++
        }   
        return res
    }
}