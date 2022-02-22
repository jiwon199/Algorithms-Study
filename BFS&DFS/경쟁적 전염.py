#백준 18405
from collections import deque
n,k=list(map(int,input().split()))
graph=[]
for _ in range(n):
  graph.append(list(map(int,input().split())))

times=[[0]*n for _ in range(n)]
s,x,y=list(map(int,input().split()))

def bfs():
  queue=deque()
  for start in starts:
    queue.append((start[0],start[1],0))
    times[start[0]][start[1]]=0
  dx=[-1,1,0,0]
  dy=[0,0,-1,1]
  while queue :
    x,y,time=queue.popleft()
    if time>=s:
      break
    time+=1
    virus=graph[x][y]
    for i in range(4):
      nx=x+dx[i]
      ny=y+dy[i]
      if nx>=n or ny>=n or nx<0 or ny<0:
        continue
      if graph[nx][ny]==0:
        queue.append((nx,ny,time))
        graph[nx][ny]=virus
        times[nx][ny]=time
      #칠해져 있지만 내가 더 우선순위 높을때
      elif graph[nx][ny]>virus and times[nx][ny]>=time:
        queue.append((nx,ny,time))
        graph[nx][ny]=virus
     
     
       
starts=[]
for i in range(n):
  for j in range(n):
    if graph[i][j]!=0:
      starts.append((i,j))
bfs()     
print(graph[x-1][y-1])


