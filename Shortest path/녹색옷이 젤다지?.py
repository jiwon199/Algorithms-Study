import heapq
#백준 4485
def dijkstra(graph,visited,n):
  q=[]
  heapq.heappush(q,(graph[0][0],0,0))
  dx=[-1,1,0,0]
  dy=[0,0,-1,1]
  distance=[[1e9]*n for _ in range(n)]
  distance[0][0]=graph[0][0]
  while q:
    cost,x,y=heapq.heappop(q)
    if x==n-1 and y==n-1:
      break
    if cost>distance[x][y]:
      continue
    for i in range(4):
      nx=x+dx[i]
      ny=y+dy[i]

      if nx>=0 and ny>=0 and nx<n and ny<n:
        newCost=cost+graph[nx][ny]
        if newCost<distance[nx][ny]:
          distance[nx][ny]=newCost
          heapq.heappush(q,(newCost,nx,ny))
  return distance[n-1][n-1]
    

count=1
answer=[]
while True:
  n=int(input())
  if n==0:
    break
  graph=[]
  visited=[[False]*n for _ in range(n)]
  for _ in range(n):
    graph.append(list(map(int,input().split())))
  res=dijkstra(graph,visited,n)
  answer.append(res)
for ans in answer:
  #print("Problem",count,":",ans)
  print("Problem ",end='')
  print(count,end='')
  print(":",ans)
  
  count+=1
 
