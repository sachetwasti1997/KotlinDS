// [0,3,7,2,5,8,4,6,0,1]
// 9
class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        var set = HashSet<>(nums.size)
        for(i in nums)set.add(i)
        var res = 0
        for(i in nums){
            if(set.contains(i-1))continue
            var max = 1
            while(set.contains(i+1)){
                max++
                i = i + 1
            }
            res = Math.max(res, max)
        }
        return res
    }
}