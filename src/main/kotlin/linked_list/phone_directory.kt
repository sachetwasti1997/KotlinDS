class PhoneDirectory(maxNumbers: Int) {

    class Slots(val index: Int, var next: Slots ?= null, var reserved: Boolean = false)
    var head: Slots ?= null 
    init{
        head = Slots(0)
        var h = head
        for(i in 1 until maxNumbers){
            h?.next = Slots(i)
            h = h?.next
        }
    }

    fun get(): Int {
        var h = head
        while(h != null){
            if(h.reserved == false){
                h.reserved = true
                return h.index
            }
            h = h.next
        }
        return -1
    }

    fun check(number: Int): Boolean {
        var h = head
        while(h != null){
            if(h.index == number){
                return !h.reserved
            }
            h = h.next
        }       
        return false
    }

    fun release(number: Int) {
        var h = head
        while(h != null){
            if(h.index == number){
                h.reserved = false
                break
            }
            h = h.next
        }       
    }

}