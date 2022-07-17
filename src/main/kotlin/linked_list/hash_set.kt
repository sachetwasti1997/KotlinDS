class ListNode(var `val` : Int, var next: ListNode? = null)

class MyHashSet(val capacity: Int = 100, var list: ArrayList<ListNode?> = ArrayList(capacity)) {

    fun add(key: Int) {
        val k = key % capacity
        if(list[k] != null){
            var h = list[k]
            while(h?.next != null){
                if(h.`val` == key)return
                h = h.next
            }
            if(h?.`val` == key)return
            h?.next = ListNode(key)
        }else{
            list[k] = ListNode(key)
        } 
    }

    fun remove(key: Int) {
        val k = key % capacity
        if(list[k]?.`val` == `val`){
            list[k] = list[k]?.next
            return
        }
        var h = list[k]
        while(h?.next != null){
            if(h.next.`val` == key){
                h.next = h.next?.next
            }
            h = h.next
        }
    }

    fun contains(key: Int): Boolean {
        val k = key % capacity
        var h = list[k]
        while(h != null){
            if(h.`val` == key)return true
            h = h.next
        }
        return false
    }

}