class ListNode:
    def __init__(self, val: int, left = None):
        self.val = val
        self.left = left


class Solution:
    def splitListToParts(self, head: Optional[ListNode], k: int) -> List[Optional[ListNode]]:
        if head is None:
            return [[head]]
        res = [None] * k
        cnt = 0
        h = head
        while h:
            h = h.next
            cnt += 1
        h = head
        i = 0
        if cnt <= k:
            while h:
                tmp = h
                res[i] = tmp
                h = h.next
                res[i].next = None
                i++
            return res
        lst = [cnt // k for i in range(k)]
        i, indx = cnt % k, 0
        while i > 0:
            lst[indx++] += 1
            i--
        indx = 0
        for i in lst:
            c = i
            h = head
            while h and c > 1:
                h = h.next
                c--
            res[indx++] = head
            head = h.next
            h.next = None
        return res
        