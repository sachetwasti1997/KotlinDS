class MyHashMap() {

    class ListNode(val key: Int, val value: Int, var next: ListNode? = null)

    val capacity = 100
    val list = ArrayList<ListNode?>(100){null}
    fun put(key: Int, value: Int) {
        val k = key % capacity
        if(list[k] != null){
            var h = list[k]
            while(h?.next != null){
                if(h.next?.key == key){
                    h.next?.value = value
                    return
                }
                h = h.next
            }
            if(h?.key == key){
                h?.value = value
                return
            }
            h?.next = ListNode(key, value)
        }else{
            list[k] = ListNode(key, value)
        }
    }

    fun get(key: Int): Int {
        val k = key % capacity
        if(list[k]?.key == key)return list[k]?.value
        var h = list[k]
        while(h != null){
            if(h.key == key)return h.value
            h = h.next
        }
        return -1
    }

    fun remove(key: Int) {
        val k = key % capacity
        if(list[k]?.key == key){
            list[k] = list[k]?.next
            return
        }
        var h = list[k]
        while(h?.next != null){
            if(h.next?.key == key){
                h.next = h.next?.next
                return
            }
            h = h?.next
        }
    }

}