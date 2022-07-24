class Solution {
    fun removeDuplicates1(nums: IntArray): Int {
        fun swap(k:Int, l:Int){
            val tmp = nums[k]
            nums[k] = nums[l]
            nums[l] = tmp
        }
        var i = 1
        var sz = 1
        while(i < nums.size){
            if(nums[i] == nums[i-1]){
                var k = i
                while(k < nums.size && nums[i] == nums[k])k++
                if(k == nums.size)break
                swap(k, sz)
                sz = k
                i = k
            }
            i++
        }
        return sz
    }
    fun removeDuplicates(nums: IntArray): Int {
        if(n < 2)return n
        var id = 1
        for(i in 1 until nums.size){
            if(nums[i] != nums[i-1])nums[id++] = nums[i]
        }
        return id
    }
}