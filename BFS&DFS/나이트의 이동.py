#백준 7562
from collections import deque
def bfs(l):
  start=list(map(int,input().split()))
  target=list(map(int,input().split()))
  queue=deque()
  #그래프가 0이 아니면 방문한 좌표. 거리를 기록하자.
  graph=[[0 for _ in range(l)] for _ in range(l)] 
  queue.append(start)
  graph[start[0]][start[1]]=1
  dx=[1,2,-1,-2,1,2,-1,-2]
  dy=[2,1,2,1,-2,-1,-2,-1]
   
  while queue:
    x,y=queue.popleft()
    if x==target[0] and y==target[1]:    
      break
    for i in range(8):
      nx=x+dx[i]
      ny=y+dy[i]
      if nx<0 or ny<0 or nx>=l or ny>=l:
        continue
      if graph[nx][ny]==0:
        queue.append([nx,ny])
        graph[nx][ny]=graph[x][y]+1

  return graph[target[0]][target[1]]-1



test=int(input())
for i in range(test):
  l=int(input())
  print(bfs(l))
