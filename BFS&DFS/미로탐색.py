#백준 2178
from collections import deque

def bfs(x,y):
  queue=deque()
  queue.append((x,y))
   
  while queue:
    x,y=queue.popleft()
    for i in range(4):
      nx=x+dx[i]
      ny=y+dy[i]
        
      if nx <=-1 or ny <=-1 or nx>=n or ny >=m:       continue
      
      if graph[nx][ny]==1:
        queue.append((nx,ny))              
        graph[nx][ny]=graph[x][y]+1
           
  return graph[n-1][m-1]


#nx는~4(n) ny는 ~6(m)

n,m=list(map(int,input().split()))
graph=[]
visited=[]
for i in range(n):
  graph.append(list(map(int,input())))
 
dx=[-1,1,0,0]
dy=[0,0,-1,1]
 

print(bfs(0,0))
