#백준 11404 이론참고 이코테 253p
INF=int(1e9)
n=int(input()) #노드
m=int(input()) #간선

graph=[[INF]*(n+1) for _ in range(n+1)]

#자기 자신으로 가는 비용은 0으로 초기화 
for a in range(1,n+1):
  for b in range(1,n+1):
    if a==b:
      graph[a][b]=0

for _ in range(m):
  #a에서 b로 가는 비용이 c 
  a,b,c=list(map(int,input().split()))  
  graph[a][b]=min(c,graph[a][b])

for k in range(1,n+1):
  for a in range(1,n+1):
    for b in range(1,n+1):
      graph[a][b]=min(graph[a][b],graph[a][k]+graph[k][b])

for a in range(1,n+1):
  for b in range(1,n+1):
    if graph[a][b]==INF:
      print("0",end=' ')
    else:
      print(graph[a][b],end=' ')
  print()
 
 
 
