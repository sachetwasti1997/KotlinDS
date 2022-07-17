class Solution {
    fun countPairs(nums1: IntArray, nums2: IntArray): Long {
        var res = 0
        for(i in 0 until nums1.size){
            for(j in i+1 until nums1.size){
                if(nums1[i] + nums1[j] > nums2[i] + nums2[j])res++
            }
        }       
        return res
    }
}