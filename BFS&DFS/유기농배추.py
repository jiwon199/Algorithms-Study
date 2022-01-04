#백준 1012
from collections import deque

def bfs(x,y):
  queue=deque()
  queue.append((x,y))
  visited[x][y]=True

  while queue:
    x,y=queue.popleft()
    for i in range(4):
      nx= x+dx[i]
      ny=y+dy[i]

      if nx <0 or ny <0 or nx >=m or ny >=n:
        continue
      if graph[nx][ny]==1 and visited[nx][ny]==False:
        queue.append((nx,ny))
        visited[nx][ny]=True

     


loop=int(input())
dx=[-1,1,0,0]
dy=[0,0,-1,1]

for _ in range(loop):
  m,n,k=list(map(int, input().split()))

  '''
  입력되는 좌표평면 상에서 배추 위치 x,y는 2차원 리스트의 가로 세로와 반대임! 
  이차원 리스트에서 (1,0)은 두번째 줄 첫번째 원소인데 좌표평면에서 (1,0)은 첫번째 줄 두번째 원소...
  그러니 안헷갈리게 가로세로를 뒤집어서 초기화하자. 이후 bfs 호출 시에도 가로(m)이 먼저 오는 2중루프문으로 구성!
  '''
  graph=[[0]*n for _ in range(m)]
  visited=[[False]*n for _ in range(m)]
   
  count=0

  for _ in range(k):
    a,b=list(map(int, input().split()))
    graph[a][b]=1

 
   
  for i in range (m):
    for j in range(n):
      if visited[i][j]==False and graph[i][j]==1:
        bfs(i,j)
        count+=1
  print(count)
