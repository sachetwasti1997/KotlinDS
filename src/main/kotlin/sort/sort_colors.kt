class Solution {
    fun sortColors(nums: IntArray): Unit {
        fun swap(x: Int, y: Int){
            var tmp = nums[y]
            nums[y] = nums[x]
            nums[x] = tmp
        }
        var i = 0
        var z = 0
        var t = nums.size - 1
        while(i <= t){
            if(nums[i] == 0){
                swap(i, z)
                i++
                z++
            }else if(nums[i] == 1){
                i++
            }else{
                swap(i, t)
                t--
            }
        }        
    }
}
