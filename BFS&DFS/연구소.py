#백준 14502
from collections import deque 
from itertools import combinations
def bfs(n,m,start):
  queue=deque()
  queue.append(start)  
  visited[start[0]][start[1]]=True
  dx=[0,0,1,-1]
  dy=[1,-1,0,0]
  while queue:
    x,y=queue.popleft()
     
    for i in range(4):     
      nx=x+dx[i]
      ny=y+dy[i]
      if nx>=n or ny>=m or nx<0 or ny<0:
        continue
       
      if visited[nx][ny]==False and graph[nx][ny]==0:
        graph[nx][ny]=2
        visited[nx][ny]==True
        queue.append((nx,ny))
        
        
  return 0

n,m=list(map(int,input().split())) #세로, 가로
graph=[]
visited=[]
 
for i in range(n):
  temp=list(map(int,input().split()))
  graph.append(temp)
  
visited=[[False]*m for _ in range(n)]
Origraph=[[0]*m for _ in range(n)]
arr=[]
for i in range(n):
  for j in range(m):
    if graph[i][j]==0:
      arr.append((i,j))
    Origraph[i][j]=graph[i][j]


ans=[]
walls=list(combinations(arr,3))
#2행 1열, 1행 2열, 4행 6열
#walls=[((2,0),(2,0),(2,0)),((1,0),(0,1),(3,5))] 
 
for wall in walls: 
  count=0
  for w in wall:
    graph[w[0]][w[1]]=1
   
  for i in range(n):
    for j in range(m):
      if graph[i][j]==2 and visited[i][j]==False:
        bfs(n,m,(i,j)) 
  for i in range(n):
    for j in range(m):
      if graph[i][j]==0:
        count+=1
  ans.append(count) 
  visited=[[False]*m for _ in range(n)]
  for i in range(n):
    for j in range(m):
      graph[i][j]=Origraph[i][j]
  
ans=sorted(ans)
print(ans[-1])
 
 
 
