package linked_list

class LRUCache(private val capacity: Int) {
    class Node(val key: Int, var value: Int, var prev: Node? = null, var next: Node? = null)
    val lru = HashMap<Int, Node>()
    var head: Node? = null
    var tail: Node? = null
    var size = 0
    private fun moveToTop(node: Node?){
        if(node == head)return
        if(node == tail){
            node?.prev?.next = node?.next
            tail = tail?.prev
            node?.prev = null
            node?.next = head
            head?.prev = node
            head = node
            return
        }
        val prev = node?.prev
        val next = node?.next
        prev?.next = next
        next?.prev = prev
        node?.prev = null
        node?.next = head
        head?.prev = node
        head = node
    }
    fun get(key: Int): Int? {
        if(lru[key] == null)return -1
        moveToTop(lru[key])
        return lru[key]?.value
    }
    fun put(key: Int, value: Int) {
        if(lru[key] == null){
            lru[key] = Node(key, value)
        }else{
            lru[key]?.value = value
            moveToTop(lru[key])
            return
        }
        val node = lru[key]
        node?.next = head
        head?.prev = node
        head = node
        size++
        if(tail == null)tail = head
        if(size > capacity){
            val temp = tail
            temp?.let{lru.remove(it.key)}
            tail = tail?.prev
            size--
        }
    }
}

fun main(){
    val lru = LRUCache(2)
    lru.put(1, 1)
    lru.put(2, 2)
    println(lru.get(1))
    lru.put(3, 3)
    println(lru.get(2))
    lru.put(4, 4)
    println(lru.get(1))
    println(lru.get(3))
    println(lru.get(4))
}