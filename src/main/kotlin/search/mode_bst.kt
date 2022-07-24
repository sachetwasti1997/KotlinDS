class Solution {
    fun findMode(root: TreeNode?): IntArray {
        var max_mod = 0
        var curr_mod = 1 
        var prev = Int.MIN_VALUE
        var res = mutableListOf<Int>()
        var k = 0
        fun searchMod(rt: TreeNode?){
            if(rt != null){
                searchMod(rt.left)
                curr_mod = if(prev == rt.`val`)curr_mod+1 else 1
                if(curr_mod == max_mod)res.add(rt.`val`)
                else if(curr_mod > max_mod){
                    max_mod = curr_mod
                    res = mutableListOf<Int>(rt.`val`)
                } 
                prev = rt.`val`
                searchMod(rt.right)
            }
        }     
        searchMod(root)
        return res.toIntArray()
    }
}