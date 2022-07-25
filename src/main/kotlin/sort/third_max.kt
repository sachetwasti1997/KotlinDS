class Solution {
    fun thirdMax(nums: IntArray): Int {
        if(nums.size == 1)return nums[0]
        nums.sortWith{x,y -> y.compareTo(x)}
        var maxCnt = 0
        var res = Long.MAX_VALUE
        for(i in nums){
            if(res > i){
                res = i.toLong()
                maxCnt ++
                if(maxCnt == 3)break
            }
        }
        return res.toInt()
    }
    fun thirdMax(nums: IntArray): Int{
        var one = Long.MIN_VALUE
        var two = Long.MIN_VALUE
        var three = Long.MIN_VALUE
        for(i in nums){
            when{
                i > one ->{
                    one = i.toLong()
                    two = one
                    three = two
                }
                i > two && i < one -> {
                    two = i.toLong()
                    three = two
                }
                i > three && i < two -> three = i.toLong()
                else -> {}
            }
        }
        return if(three > Long.MIN_VALUE) three else one
    }
}