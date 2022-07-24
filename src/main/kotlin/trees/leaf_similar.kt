class Solution {
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        var similar = true
        fun dfs(rt1: TreeNode?, rt2: TreeNode?){
            if(rt1 == null){
                if(rt1 != rt2)similar = false
            }
            if(rt1?.left == null && rt1?.right == null){
                if(rt1?.`val` != rt2?.value)similar = false
            }
            dfs(rt1?.left, rt2?.left)
            dfs(rt1?.right, rt2?.right)
        }       
    }
}