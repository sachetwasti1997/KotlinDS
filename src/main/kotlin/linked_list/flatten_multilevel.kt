class Solution {
    fun flatten(root: Node?): Node? {
        if(root == null) return null
        var h = root
        while(h != null){
            var ch = h.child
            if(ch != null){
                val t = h.next
                ch.prev = h
                h.next = ch
                while(ch?.next != null){
                    ch = ch?.next
                }
                ch?.next = t
                t?.prev = ch
            }
            h = h.next
        }       
        return root
    }
}