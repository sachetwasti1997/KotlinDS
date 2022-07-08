package linked_list

class Solution14 {
    fun isPalindrome(head: ListNode?): Boolean {
        head?.let{
            fun reverseList(head: ListNode?): ListNode?{
                var prev: ListNode? = null
                var curr = head
                var fast = head?.next
                while(fast != null){
                    curr?.next = prev
                    prev = curr
                    curr = fast
                    fast = fast?.next
                }
                curr?.next = prev
                return curr
            }
            var slow: ListNode? = null
            var currnt: ListNode? = it
            var nxt: ListNode? = it
            while(nxt?.next != null){
                slow = currnt
                currnt = currnt?.next
                nxt = nxt.next?.next
            }
            slow?.next = null
            currnt = reverseList(currnt)
            slow = head
            while(slow!= null && currnt != null){
                if(slow.`val` != currnt.`val`)return false
                slow = slow.next
                currnt = currnt.next
            }
            return true
        }
        return true
    }
}

fun main(){
    val s = Solution14()
    val l1 = ListNode(1)
    val l2 = ListNode(2)
    val l3 = ListNode(2)
    val l4 = ListNode(1)
    l1.next = l2
    l2.next = l3
    l2.next = l4
    s.isPalindrome(l1)
}