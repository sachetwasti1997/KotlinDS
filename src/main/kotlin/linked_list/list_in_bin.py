class ListNode:
    def __init__(self, val = 0, next = None):
        self.val = val
        self.next = next

class TreeNode:
    def __init__(self, val = 0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isSubPath(self, head: Optional[ListNode], root: Optional[TreeNode]) -> bool:
        def dfs(h: Optional[ListNode], r: Optional[TreeNode]) -> bool:
            if r is None:
                return False
            if h.val == r.val:
                if bfs(h.next, r):
                    return True
            return dfs(h, r.left) or dfs(h, r.right)

        def bfs(h: Optional[ListNode], r: Optional[TreeNode]) -> bool:
            q = deque()
            q.append(r)
            while len(q) > 0 and h:
                for i in range(len(q)):
                    tmp = q.popleft()
                    if tmp.left and tmp.left.val == h.val:
                        q.append(tmp.left)
                    if tmp.right and tmp.right.val == h.val:
                        q.append(tmp.right)
                if len(q) > 0:
                    h = h.next

            return h is None

        return dfs(head, root)

    def isSubPath(self, head: Optional[ListNode], root: Optional[TreeNode]) -> bool:
        def dfs(r:Optional[TreeNode], h:Optional[ListNode]):
            if r is None:
                return False
            if matches(r,h):
                return True
            return dfs(r.left, h) or dfs(r.right, h)
        
        def matches(r:Optional[TreeNode], h:Optional[ListNode]):
            if not h:
                return True
            if not r or h.val != r.val:
                return False
            return matches(r.left, h.next) or matches(r.right, h.next)
        return dfs(root, head)



