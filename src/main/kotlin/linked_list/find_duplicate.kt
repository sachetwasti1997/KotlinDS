package linked_list

fun findDuplicate(nums: IntArray): Int {
    var slow = 0
    var fast = 0
    while(true){
        slow = nums[slow]
        fast = nums[nums[fast]]
        if(slow == fast)break
    }
    var s = 0
    while(s != slow){
        s = nums[s]
        slow = nums[slow]
    }
    return slow
}