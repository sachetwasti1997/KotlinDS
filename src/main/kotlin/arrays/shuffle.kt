class Solution {
    fun shuffle(nums: IntArray, n: Int): IntArray {
        if(nums.size == 1)return nums
        val res = IntArray(nums.size)
        var i = 0; var n1 = n; var k = 0
        while(i < n && n1 < nums.size){
            res[k++] = nums[i++]
            res[k++] = nums[n1++]
        }
        return res
    }
}