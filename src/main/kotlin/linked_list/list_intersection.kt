class Solution {
    fun getIntersectionNode(headA:ListNode?, headB:ListNode?):ListNode? {
        if(headA == null)return null
        if(headB == null)return null
        var a = headA; var b = headB
        val set = HashSet<ListNode>()
        while(a != null){
            set.add(a)
            a = a.next
        }
        var node: ListNode? = null
        while(b != null){
            if(set.contains(b)){
                node = b
                break
            }
            b = b.next
        }
        return node
    }
}