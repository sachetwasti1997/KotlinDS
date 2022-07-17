class Solution {
    fun deleteNode(node: ListNode?) {
        var n = node
        n?.`val` = n?.next?.`val` ?: 0
        n?.next = n?.next?.next
    }
}