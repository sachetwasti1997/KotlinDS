class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        mp = {i:0 for i in s}
        for i in s:
            mp[i] += 1
        for i in t:
            if not mp.get(i):
                return false
            mp[i] -= 1
            if mp[i] == 0:
                del mp[i]
        return True