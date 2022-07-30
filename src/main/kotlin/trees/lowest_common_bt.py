class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def find_path(root: Optional['TreeNode'], l, p:'TreeNode') -> bool:
            if root is None:
                return False
            left = find_path(root.left, l, p)
            right = find_path(root.right, l, p)
            if left or right or root == p:
                l.append(root)
                return True
            return False
        l1, l2 = [], []
        find_path(root, l1, p)
        find_path(root, l2, q)
        i, j = len(l1) - 1, len(l2) - 1
        res = None
        while i >= 0 and j >= 0:
            if l1[i] == l2[j]:
                res = l1[i]
            else:
                break
        
        return res

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root is None:
            return None
        if root == p or root == q:
            return root
        left = lowestCommonAncestor(root.left, p, q)
        right = lowestCommonAncestor(root.right, p, q)
        if left is None:
            return right
        elif right is None:
            return left
        else:
            return root
        