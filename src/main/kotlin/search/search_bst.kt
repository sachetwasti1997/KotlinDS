class Solution {
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        var node: TreeNode? = null
        fun search(rt: TreeNode?){
            if(rt != null){
                if(rt.`val` < `val`)search(rt.right)
                else if(rt.`val` > `val`)search(rt.left)
                else node = rt
            }
        }     
        search(root)
        return node
    }
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        return when{
            root == null -> null
            root.`val` == `val` -> root
            root.`val` > `val` -> searchBST(root.left, `val`)
            root.`val` < `val` -> searchBST(root.right, `val`)
        }
    }
}