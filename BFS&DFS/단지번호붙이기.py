#백준 2667
from collections import deque

def bfs(x,y):  
  queue=deque()
  queue.append((x,y))
  visited[x][y]=True

  count=1
  while queue:
    x,y=queue.popleft()
    for i in range(4):
      nx=x+dx[i]
      ny=y+dy[i]

      if nx < 0 or nx >=n or ny <0 or ny>=n: 
        continue
      
      if visited[nx][ny]==False and graph[nx][ny]==1:
        queue.append((nx,ny))
        visited[nx][ny]=True
        count+=1
  return count


n=int(input())       
graph= []
visited=[[False]*(n) for _ in range(n)]

for _ in range (n):
  graph.append(list(map(int,input())))

dx=[-1,1,0,0]
dy=[0,0,-1,1]
 
result=[]
number=0
for i in range (n):
  for j in range(n):
    if graph[i][j]==1 and visited[i][j]==False:
      result.append(bfs(i,j))
      number+=1
result.sort()
print(number)
for i in result:
  print(i)
