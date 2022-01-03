#이코테 152p 그래프 실전문제2
from collections import deque

def bfs(x,y):
  queue=deque()
  queue.append((x,y))

  while queue:
    x,y=queue.popleft()

    for i in range(4):
      nx=dx[i]+x
      ny=dy[i]+y
      #공간 밖으로 나가면 무시. x가 세로 좌표인듯 (목적지가 (n,m). m개짜리 n줄 미로.)
      if nx < 0 or nx >= n or ny < 0 or ny >= m:
        continue
      #벽이면 무시
      if graph[nx][ny]==0:
        continue
      # 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
      if graph[nx][ny] == 1:
        # 해당 위치로 가기 위한 최단 거리 기록...
        graph[nx][ny] = graph[x][y] + 1
        queue.append((nx, ny))
  # 가장 오른쪽 아래까지의 최단 거리 반환
  return graph[n - 1][m - 1]

n,m=list(map(int,input().split()))

graph=[]
for i in range (n):
  graph.append(list(map(int,input())))

dx=[-1,1,0,0]
dy=[0,0,-1,1]

print(bfs(0,0))
