package trees

fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    val rtval = root?.`val` ?: -1
    val pval = p?.`val` ?: -1
    val qval = q?.`val`	?: -1
    if((rtval > pval && rtval < qval)||(rtval < pval && rtval > qval))return root
    if(rtval == pval || rtval == qval)return root
    if(pval < rtval && qval < rtval)
        return lowestCommonAncestor(root?.left, p, q)
    else
        return lowestCommonAncestor(root?.right, p, q)
}