#백준 18352
from collections import deque
import sys
def bfs(start,k):
  queue=deque()
  queue.append((start,0))
   
  while queue:
     
    now=queue.popleft()
    index=now[0]
    count=now[1]
    if distance[index]==-1:
      distance[index]=count
    for g in graph[index]:
      if distance[g]==-1:
        queue.append((g,count+1))
    count+=1
 
n,m,k,start=list(map(int,sys.stdin.readline().split()))
 
graph=[[] for _ in range(n+1)]

for i in range(m):
  a,b=list(map(int,sys.stdin.readline().split()))
  graph[a].append(b)

distance=[-1]*(n+1)
bfs(start,k)
check=0
for i in range(n+1):
  if distance[i]==k:
    print(i)
  else:
    check+=1

if check==n+1:
  print(-1)
