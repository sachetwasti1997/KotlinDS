class ListNode:
    def __init__:(self, val = 0, next = None):
        self.val = val
        self.next = next


class Solution:
    def mergeInBetween(self, list1: ListNode, a: int, b: int, list2: ListNode) -> ListNode:
        l, r = None, None
        h = list1
        l1, r1 = 0, 0
        while h:
            if l1 == a - 1:
                l = h
            if r1 == b+1:
                r = h
            h = h.next
            l1+=1
            r1+=1
        l.next = list2
        while list2.next:
            list2 = list2.next
        list2.next = r
        return list1