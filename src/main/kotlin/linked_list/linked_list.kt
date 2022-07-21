class MyLinkedList() {

    class Node(val data: Int, var prev:ListNode ?= null, var next:ListNode ?= null)
    val head: Node? = null
    var length = 0

    fun fndInx(inx: Int): Node? {
        var h = head
        repeat(inx){
            h = h?.next
        }
        return h
    }

    fun get(index: Int): Int {
        fndInx(index)?.data ?: -1
    }

    fun addAtHead(`val`: Int) {
        addAtIndex(0, `val`)
    }

    fun addAtTail(`val`: Int) {
        addAtIndex(length, `val`)
    }

    fun addAtIndex(index: Int, `val`: Int) {
        if(index > length){
            return
        }
        val v = Node(`val`)
        when{
            index == 0 || length == 0 -> {
                v.next = head
                head = v
            }
            else{
                val n = findInx(index-1)
                val tmp = n?.next
                n?.next = v
                v.next = tmp
            }
        }
        length ++
    }

    fun deleteAtIndex(index: Int) {
        when{
            head == null -> return
            index == length -> return
            index == 0 -> head = head?.next
            else{
                val n = fndInx(index - 1)
                n?.next = n?.next?.next
            }
        }
        length--
    }

}