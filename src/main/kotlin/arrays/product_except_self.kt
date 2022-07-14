class Solution {
    // fun productExceptSelf(nums: IntArray): IntArray {
    //     val left = IntArray(nums.size){1}
    //     val right = IntArray(nums.size){1}
    //     var prev = 1
    //     for(i in 1 until nums.size){
    //         left[i] = prev * nums[i-1]
    //         prev *= nums[i-1] 
    //     }   
    //     prev = 1    
    //     for(i in nums.size - 2 downTo 0){
    //         right[i] = prev * nums[i+1]
    //         prev *= nums[i+1]
    //     }
    //     for(i in 0 until nums.size){
    //         nums[i] = left[i] * right[i]
    //     }
    //     return nums
    // }
    fun productExceptSelf(nums: IntArray): IntArray {
        val res = IntArray(nums.size){1}
        var prev = 1
        for(i in 0 until nums.size-1){
            prev *= nums[i]
            res[i+1] = prev
        }
        prev = 1
        for(i in nums.size-1 downTo 1){
            res[i] *= prev
            prev *= nums[i]
        }
        return res
    }
}