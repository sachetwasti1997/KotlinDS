class Solution {
    fun getDecimalValue(head: ListNode?): Int {
        val str = StringBuilder()
        var h = head
        while(h != null){
            str.append(h.`val`)
            h = h.next
        }
        val s = str.toString().reversed()
        var it = 0; val base = 2
        var res = 0
        for (i in s){
            res += (i.digitToInt() * base.toDouble().pow(it.toDouble())).toInt()
            it++
        }
        return res
    }
}