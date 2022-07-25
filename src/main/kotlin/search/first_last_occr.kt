fun searchRange(nums: IntArray, target: Int): IntArray {
        var start = -1
        var end = -1
        var l = 0
        var r = nums.size - 1
        //find start index
        loop@ while(l <= r){
            val mid = l + (r - l)/2
            when{
                nums[mid] == target -> {
                    if(mid == 0 || nums[mid] != nums[mid - 1]) {
                        start = mid
                        break@loop
                    }
                    else if(nums[mid] == nums[mid-1]) r = mid - 1
                }
                nums[mid] < target -> l = mid + 1
                else -> r = mid - 1
            }
        }
        l = 0
        r = nums.size - 1     
        //find end index
        loop@ while(l <= r){
            val mid = l + (r - l)/2
            when{
                nums[mid] == target -> {
                    if(mid == nums.size - 1 || nums[mid] != nums[mid+1]){
                        end = mid
                        break@loop
                    }
                    else if(nums[mid] == nums[mid + 1])l = mid + 1
                }
                nums[mid] < target -> l = mid + 1
                else -> r = mid - 1
            }
        }
        return intArrayOf(start, end)
    }