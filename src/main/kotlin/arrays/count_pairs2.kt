class Solution {
    /**
        Given nums1[i]+nums1[j] > nums2[i] + nums2[j]
    --->     (nums1[i]-nums2[i]) + (nums1[j]-nums2[j]) > 0    
     */
    fun countPairs(nums1: IntArray, nums2: IntArray): Long {
        val res = IntArray(nums1.size)
        for(i in 0 until nums1.size)res[i] = nums1[i] - nums2[i]
        res.sort()
        var i = 0
        var j = res.size - 1
        var r = 0
        while(i < j){
            if(res[i] + res[j] > 0){
                r++
                i++
                j--
            }else{
                i++
            }
        }
        return r
    }
}