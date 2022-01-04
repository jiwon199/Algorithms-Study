#백준 2606
from collections import deque

def BFS(start):
  queue=deque()
  queue.append(start)
  visited[start]=True
  count=0
 
  while queue:
    v=queue.popleft()

    for i in range (1,n+1):
      if graph[v][i]==1 and visited[i]==False:
        queue.append(i)      
        visited[i]=True
        count+=1
   
  
  return count

 
n=int(input()) # 컴퓨터 수 
m=int(input())  #연결 수

visited =[False] *(n+1)

graph = [[0]*(n+1) for _ in range(n+1)]

for i in range(m):
  a,b=list(map(int,input().split()))
  graph[a][b]=1
  graph[b][a]=1

print(BFS(1))
