#백준 16234
from collections import deque
import sys
def bfs(i,j):
  queue=deque()
  queue.append((i,j))
  visited[i][j]=True
  unite=[(i,j)] # 한 묶음인 애들의 위치 넣기
  sum=graph[i][j] #한 묶음인 애들의 인구수 

  dx=[-1,1,0,0]
  dy=[0,0,-1,1]
  while queue:
    x,y=queue.popleft()
    for i in range(4):
      nx=x+dx[i]
      ny=y+dy[i]
      if nx>=N or ny >= N or nx<0 or ny<0:
        continue
      minus=abs(graph[nx][ny]-graph[x][y])
      if minus>=L and minus<=R and visited[nx][ny]==False:
        visited[nx][ny]=True
        sum+=graph[nx][ny]
        unite.append((nx,ny))
        queue.append((nx,ny))
      else:
        continue
      
  l=len(unite)
  sum=sum//l
  for u in unite:
    graph[u[0]][u[1]]=sum
 
def check():
  print()
N,L,R=list(map(int,sys.stdin.readline().split()))
graph=[]
for _ in range(N):
  graph.append(list(map(int,sys.stdin.readline().split())))
  
 
day=0
while True:
  count=0
  visited=[[False]*N for _ in range(N)]
  for i in range(N):
    for j in range(N):
      if visited[i][j]==False:
        bfs(i,j)
        count+=1
         
  if count==N*N:
    break
  day+=1
print(day)
