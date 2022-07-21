class Solution{
fun numComponents(head: ListNode?, nums: IntArray): Int {
    val s = HashSet<Int>(nums.size)
    for(i in nums)s.add(i)
    var maxLength = 0
    var h = head
    while(h != null){
        if(s.contains(h.`val`))maxLength++
        while(h?.next != null && s.contains(h.`val`)){
            h = h.next
        }
        h = h?.next
    }
    return maxLength
}
}