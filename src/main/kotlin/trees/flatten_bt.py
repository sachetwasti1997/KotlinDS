class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        if root is None:
            return None
        def helper(root: Optional['TreeNode']) -> Optional[TreeNode]:
            if root is None:
                return None
            left = helper(root.left)
            right = helper(root.right)
            if left is not None:
                tmp = root.right
                root.right = root.left
                tmp2 = root.right
                root.left = null
                while tmp2.right is not None:
                    tmp2 = tmp2.right
                tmp2.right = tmp
            return root
        helper(root)
    
    def flatten(self, root: Optional[TreeNode]) -> None:
        if root is None:
            return
        while root is not None:
            if root.left is not None:
                left = root.left
                curr = left
                while curr.right is not None:
                    curr = curr.right
                curr.right = root.right
                root.left = None
                root.right = left
            root = root.right

class Solution {
    fun flatten(root: TreeNode?): Unit {
        if(root == null)return
        fun helper(root: TreeNode?): TreeNode?{
            if(root == null)return null
            val left = helper(root.left)
            val right = helper(root.right)
            if(left != null){
                val tmp = root.right
                root.right = left
                root.left = null
                var tmp2 = rt.right
                while(tmp2?.right != null)tmp2 = tmp2?.right
                tmp2?.right = tmp
            }
            return root
        }
        helper(root)
    }

    fun flatten(root: TreeNode?): Unit {
        if(root == null)return
        var rt = root
        while(rt != null){
            if(rt.left != null){
                val l = rt.left
                var curr = l
                while(curr?.right != null)curr = curr?.right
                curr?.right = l
                rt.left = null
                rt.right = curr
            }
            rt = rt.right
        }   
    }
}
            