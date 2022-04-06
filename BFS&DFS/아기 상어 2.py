#백준 17086
from collections import deque

array=[]
n,m=list(map(int,input().split()))
graph=[]
 
for i in range(n):
  graph.append(list(map(int,input().split())))
 


def bfs(i,j,visited,graph,distanceArray,target):
  #array.append(i)
  queue=deque()
  queue.append((i,j,0))
  visited[i][j]=True
  dx=[0,0,1,1,1,-1,-1,-1]
  dy=[-1,1,-1,0,1,-1,0,1]
   
  while queue:
    x,y,distance=queue.popleft()
    for k in range(8):
      nx=x+dx[k]
      ny=y+dy[k]
      if nx>=0 and ny>=0 and nx<n and ny<m:       
        if visited[nx][ny]==False:           
          temp=distanceArray[nx][ny]
          #print(temp,distance,nx,ny)
          distanceArray[nx][ny]=min(temp,distance+1)
          visited[nx][ny]=True
          queue.append((nx,ny,distance+1))
   
target=[]
for i in range(n):
  for j in range(m):     
    if graph[i][j]==1:
      target.append((i,j))
distanceArray=[[1000]*m for _ in range(n)]
for t in target:
  visited=[[False]*m for _ in range(n)]
  distanceArray[t[0]][t[1]]=1
  bfs(t[0],t[1],visited,graph,distanceArray,target)
   
 
       
answer=0
for i in range(n):
  for j in range(m):
    answer=max(distanceArray[i][j],answer)
print(answer)
