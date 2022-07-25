fun wiggleSort(nums: IntArray): Unit {
        val res = IntArray(nums.size)
        nums.sort()
        var i = 1
        var j = nums.size - 1
        repeat(2){
            while(i < nums.size && j >= 0){
                res[i] = nums[j]
                i += 2
                j--
            }
            i = 0
        }       
        for(i in res.indices)nums[i] = res[i]
}