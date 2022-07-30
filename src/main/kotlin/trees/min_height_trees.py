class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        g = collections.defaultdict(list)
        h = {}
        for i in edges:
            g[i[0]].append(i[1])
        
        h = 0

        def height(node: int, height: int):
            if root is None:
                return
            if h < height:
                h = height
            for i in g[node]:
                height(i, height + 1)
        
        res = float('inf')
        lst = []

        for i in g:
            dfs(i, 0)
            if res > h:
                res = h
                lst = []
                lst.append(i)
            elif res == h:
                lst.append(i)
        
        return lst