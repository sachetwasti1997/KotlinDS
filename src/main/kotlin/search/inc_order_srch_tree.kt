class Solution {
    fun increasingBST(root: TreeNode?): TreeNode? {
        var nwrt: TreeNode? = null
        var pnt: TreeNode? = null
        fun inorder(rt: TreeNode?){
            if(rt != null){
                inorder(rt.left)
                if(nwrt == null){
                    nwrt = rt
                }else{
                    pnt?.right = rt
                    rt.left = null
                }
                pnt = rt
                inorder(rt.right)
            }
        }   
        inorder(root)
        return nwrt
    }
}