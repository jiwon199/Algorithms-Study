#백준 15591
from collections import deque,defaultdict
def bfs(v,k,graph):
  count=0
  queue=deque()
  visited=[False]*(n+1)
  queue.append((v,2e9))   
  visited[v]=True
  while queue:
    a,b=queue.popleft()
    for x,y in graph[a]:
      if visited[x]==True:
        continue
      if b>y: #min(USADO)값 갱신
        queue.append((x,y))
        if y>=k:
          count+=1
      else:
        queue.append((x,b))
        if b>=k:
          count+=1
      visited[x]=True
  return count
n,q=list(map(int,input().split()))
#시간초과때문에 일반리스트 말고 라이브러리에서..ㅋㅋ
graph= defaultdict(list)
for i in range(n-1):
  a,b,c=list(map(int,input().split()))
  graph[a].append((b,c)) 
  graph[b].append((a,c))

for i in range(q):
  k,v=list(map(int,input().split()))
  print(bfs(v, k, graph))
