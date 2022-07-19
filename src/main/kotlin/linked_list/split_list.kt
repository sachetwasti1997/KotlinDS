class Solution {
    fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
        if(head == null)return arrayOf<ListNode?>(null)
        var cnt = 0
        var h = head
        while(h != null){
            h = h.next
            cnt++
        }       
        var i = 0
        h = head
        val res = Array<ListNode?>(k){null}
        if(cnt <= k){
            while(h != null){
                res[i] = h
                h = h.next
                res[i]?.next = null
                i++
            }
        }
        val size = cnt / k
        val arr = IntArray(size){size}
        var r = cnt % k
        i = 0
        while(r > 0){
            arr[i++] += 1
            r--
        }
        h = head
        var it = 0
        for(i in arr){
            var j = i
            val hd = h
            while(j > 1){
                h = h?.next
                j--
            }
            val t = h
            h = h?.next
            t?.next = null
            res[it++] = hd
        }
        return res
    }
}