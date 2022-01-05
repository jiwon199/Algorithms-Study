#백준 7576
from collections import deque
 
def bfs():
  
  while queue:
    x,y=queue.popleft()
     
    for i in range(4):
      nx=x+dx[i]
      ny=y+dy[i]      

      if nx<0 or ny <0 or nx>=m or ny >=n:
        continue
       
      elif graph[nx][ny]==0:        
        graph[nx][ny]=graph[x][y]+1
        queue.append((nx,ny))
         
    
n,m=list(map(int, input().split()))
graph=[]
for i in range (m):
   graph.append(list(map(int, input().split())))

visited=[[False]*n for _ in range(m)]
 
 
dx=[-1,1,0,0]
dy=[0,0,-1,1]

queue=deque()
   
for i in range (m):
  for j in range (n):
    if graph [i][j]==1: 
      queue.append((i,j))      
       
bfs()


 
count = max(map(max, graph))-1
for i in range (m):
  for j in range (n):
    if graph [i][j]==0: 
      count=-1
print(count)

