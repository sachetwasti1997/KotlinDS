class Solution {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        nums1.sort()
        nums2.sort()
        var i = 0
        var j = 0
        val res = ArrayList<Int>(nums1.size)
        while(i < nums1.size && j < nums2.size){
            when{
                nums1[i] == nums2[j] -> {
                    res.add(nums1[i])
                    i++
                    j++
                }
                nums1[i] > nums2[j] -> j++
                nums1[i] < nums2[j] -> i++
            }
        }       
        return res.toIntArray()
    }
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val m = HashMap<Int, Int>(nums1.size)
        val res = ArrayList<Int>(nums1.size)
        for(i in nums1)m[i] = m[i]?.plus(1) ?: 1
        for(i in nums2){
            m[i]?.let{
                if(it > 0){
                    m[i] = it-1
                    res.add(i)
                }
            }
        }
        return res.toIntArray()
    }
}