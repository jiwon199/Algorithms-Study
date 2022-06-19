#백준 2583
from collections import deque
def bfs(sx,sy,n,m,visited,graph):
  queue=deque()
  queue.append((sx,sy))
  visited[sx][sy]=True
  dx=[-1,1,0,0]
  dy=[0,0,-1,1]
  area=0
   
  while queue:
    x,y=queue.popleft()
    area+=1
    for i in range(4):
      nx=x+dx[i]
      ny=y+dy[i]
      if nx>=0 and ny>=0 and nx<m and ny<n:
        if visited[nx][ny]==False and graph[nx][ny]!=1:
          queue.append((nx,ny))
          visited[nx][ny]=True
           
   
  return area
m,n,k=list(map(int,input().split()))
graph=[[0]*n for _ in range(m)]
for _ in range (k):
  a,b,c,d=list(map(int,input().split()))
  x1=m-b-1
  y1=a
  x2=m-d
  y2=c-1
  minx=min(x1,x2)
  maxx=max(x1,x2)
  miny=min(y1,y2)
  maxy=max(y1,y2)
  for i in range(minx,maxx+1):
    for j in range(miny,maxy+1):
      graph[i][j]=1

 
visited=[[False]*n for _ in range(m)]
count=0
areas=[]
for i in range(m):
  for j in range(n):
    if graph[i][j]==0 and visited[i][j]==False:
      areas.append(bfs(i,j,n,m,visited,graph))
      count+=1
areas=sorted(areas)
print(count)
for a in areas:
  print(a,end=' ')
 
