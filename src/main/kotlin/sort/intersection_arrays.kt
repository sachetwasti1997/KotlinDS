class Solution {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val st = HashSet<Int>(nums1.size)
        val res = ArrayList<Int>(nums1.size)
        for(i in nums1)set.add(i)
        for(i in nums2){
            if(set.contains(i)){
                res.add(i)
                set.remove(i)
            }
        }       
        return res.toIntArray()
    }
}