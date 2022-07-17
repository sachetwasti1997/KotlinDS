class Solution {
    fun getIntersectionNode(headA:ListNode?, headB:ListNode?):ListNode? {
        if(headA == headB)return headA
        fun length(root: ListNode?):Int{
            if(root == null)return 0
            var r = root
            var cnt = 0
            while(r != null){
                cnt++
                r = r.next
            }
            return cnt
        }       
        val lenA = length(headA)
        val lenB = length(headB)
        var hA = headA; var hB = headB
        if(lenA > lenB){
            var m = lenA - lenB
            while(m > 0){
                hA = hA?.next
                m--
            }
        }else{
            var m = lenB - lenA
            while(m > 0){
                hB = hB?.next
                m--
            }
        }
        while(hA != null && hB != null){
            if(hA == hB)return hA
            hA = hA.next
            hB = hB.next
        }
        return null
    }
}