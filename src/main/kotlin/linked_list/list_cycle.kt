class Solution {
    class ListNode(var `val`: Int, var next: ListNode? = null)
    fun detectCycle(head: ListNode?): ListNode? {
        if(head?.next == null)return head
        var h = head
        var s = head
        var flag = 0
        while(h?.next != null){
            h = h.next?.next
            s = s?.next
            if(h == s){
                flag = 1
                break
            }
        }
        if(flag == 0)return null
        var nh = head
        while(nh != s){
            nh = nh?.next
            s = s?.next
        }
        return s
    }
}