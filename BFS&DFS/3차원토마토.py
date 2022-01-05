#백준 7569
from collections import deque

def bfs():
  maxval=1
  flag=False
  while queue:
    x,y,z=queue.popleft()
    for i in range(6):
      nx=x+dx[i]
      ny=y+dy[i]
      nz=z+dz[i]

      if nx<0 or ny<0 or nz<0 or nx >=h or ny >= n or nz>=m:
        continue
      if graph[nx][ny][nz]==0:
        graph[nx][ny][nz]=graph[x][y][z]+1
        queue.append((nx,ny,nz))
        flag=True
        if graph[nx][ny][nz]>maxval:
          maxval=graph[nx][ny][nz]
  
  if flag==False:
    return 0
  else:
    return maxval-1

 


m,n,h= list(map(int, input().split()))
graph = [[ [] for _ in range(n)] for _ in range(h)]
 
for i in range(h):
  for j in range(n):
    graph[i][j]=list(map(int, input().split()))


dx=[-1,1,0,0,0,0]
dy=[0,0,-1,1,0,0]
dz=[0,0,0,0,-1,1]

queue=deque()

cnt=0
for i in range(h):
  for j in range(n):
    for k in range(m):
      if graph[i][j][k]==1:
        queue.append((i,j,k))
       


res=bfs()
for i in range(h):
  for j in range(n):
    for k in range(m):
      if graph[i][j][k]==0:
        res=-1
print(res)
 
  
