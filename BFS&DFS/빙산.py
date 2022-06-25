#백준 2573
from collections import deque
def bfs(sx,sy,visited,n,m):
  queue=deque()
  queue.append((sx,sy))
  visited[sx][sy]=True
  dx=[-1,1,0,0]
  dy=[0,0,-1,1]
  while queue:
    x,y=queue.popleft()
    for i in range(4):
      nx=x+dx[i]
      ny=y+dy[i]
      if nx>=0 and ny>=0 and nx<n and ny<m:
        if visited[nx][ny]==False and graph[nx][ny]!=0:
          visited[nx][ny]=True
          queue.append((nx,ny))
    
def countArea(n,m):
  area=0
  visited=[[False]*m for _ in range(n)]
  for i in range(n):
    for j in range(m):
      if graph[i][j]!=0 and visited[i][j]==False:
        bfs(i,j,visited,n,m)
        area+=1
  return area
  
def getWater(nearWater,n,m):
  dx=[-1,1,0,0]
  dy=[0,0,-1,1]
  for i in range(n):
    for j in range(m):
      if graph[i][j]!=0:
        count=0
        for k in range(4):
          nx=i+dx[k]
          ny=j+dy[k]
          if nx>=0 and ny>=0 and nx<n and ny<m:
            if graph[nx][ny]==0:
              count+=1
        nearWater[i][j]=count
          
   
  
def melt(n,m):
  nearWater=[[0]*m for _ in range(n)]
  getWater(nearWater,n,m)
  for i in range(n):
    for j in range(m):
      if graph[i][j]!=0:
        graph[i][j]=max(0,graph[i][j]-nearWater[i][j])

n,m=list(map(int,input().split()))
graph=[]
for _ in range(n):
  graph.append(list(map(int,input().split())))
 
time=0
while True:  
  area=countArea(n,m)
  if area>=2:
    break
  elif area==0:
    time=0
    break
  
  melt(n,m)
  time+=1

print(time)
 
 
      
