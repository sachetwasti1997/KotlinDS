class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        if n == 1:
          return [0]
        
        deg = {i:0 for i in range(0, n)}
        g = {i:[] for i in range(0, n)}
        
        for i in edges:
            g[i[0]].append(i[1])
            g[i[1]].append(i[0])
            deg[i[0]]+=1
            deg[i[1]]+=1
        
        q = deque()
        v = set()
        for i in deg:
            if deg[i] == 1:
                q.append(i)
                v.add(i)
                
        res= []
        while len(q) > 0:
            res = []
            for j in range(0, len(q)):
              tmp = q.popleft()
              res.append(tmp)
              for i in g[tmp]:
                  if i not in v:
                    deg[i]-=1
                    if(deg[i] == 1):
                        q.append(i)
                        v.add(i)
        
        return res