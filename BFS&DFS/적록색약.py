from collections import deque
def bfs(graph,sx,sy,visited):
  queue=deque()
  queue.append((sx,sy))
  visited[sx][sy]=True
  color=graph[sx][sy]
  dx=[-1,1,0,0]
  dy=[0,0,-1,1]

  while queue:
    x,y=queue.popleft()
    for i in range(4):
      nx=x+dx[i]
      ny=y+dy[i]

      if nx>=0 and ny>=0 and nx<n and ny<n:
        if visited[nx][ny]==False and graph[nx][ny]==color:
          queue.append((nx,ny))
          visited[nx][ny]=True

  
 
origin=[]
n=int(input())
for i in range(n):
  temp=input()
  arr=[]
  for j in range(n):
    arr.append(temp[j])
  origin.append(arr)
  
graph1=[[0]*n for _ in range(n)] #원본
graph2=[[0]*n for _ in range(n)] #적록색맹(R,G 같은 취급)

for i in range(n):
  for j in range(n):
    if origin[i][j]=='R':
      graph1[i][j]=0
      graph2[i][j]=1
    elif origin[i][j]=='G':
      graph1[i][j]=1
      graph2[i][j]=1
    elif origin[i][j]=='B':
      graph1[i][j]=2
      graph2[i][j]=2

area1=0
area2=0
visited1=[[False]*n for _ in range(n)]
visited2=[[False]*n for _ in range(n)]
for i in range(n):
  for j in range(n):
    if visited1[i][j]==False:
      bfs(graph1,i,j,visited1)
      area1+=1
    if visited2[i][j]==False:
      bfs(graph2,i,j,visited2)
      area2+=1
print(area1, area2)
      
 
