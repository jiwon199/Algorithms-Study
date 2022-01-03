#백준 1260
from collections import deque

def BFS(start):
  queue=deque()
  queue.append(start)
  visited2[start]=True
  
  while queue:
    v=queue.popleft()
    print(v, end=' ') #줄바꿈 없이 공백 기준으로 출력
    for i in range(n+1):      
      if graph[v][i]==1 and visited2[i]==False:     
        queue.append(i)
        visited2[i]=True


def DFS(v):   
  visited[v]=True
  print(v, end=' ')
 
  for i in range(n+1):
    if graph[v][i]==1 and visited[i]==False:     
      DFS(i)
    
  


n,m,start=list(map(int,input().split()))
graph = [[0]*(n+1) for _ in range(n + 1)]

for i in range(m):
  a,b=map(int,input().split())
  graph[a][b]=1
  graph[b][a]=1

visited=[False]*(n+1)
DFS(start)

print()

visited2=[False]*(n+1)
BFS(start)

