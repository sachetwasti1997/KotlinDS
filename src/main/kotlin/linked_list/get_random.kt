class Solution(head: ListNode?) {

    var curr: ListNode? = head

    fun getRandom(): Int {
        if(curr == null)curr = head
        var value = curr?.`val`
        curr = curr?.next
        return value
    }

}