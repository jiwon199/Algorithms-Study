from collections import deque
#백준 16236
def canGo(a,b,size):
  queue=deque()
  queue.append((pos[0],pos[1]))
  dx=[-1,1,0,0]
  dy=[0,0,-1,1]
  l=len(graph)
   
  for i in range(l):
    for j in range(l):
      visited[i][j]=1e9
  visited[pos[0]][pos[1]]=0
  while queue:
    x,y=queue.popleft()
    if x==a and y==b:
      break
    for i in range(4):
      nx=x+dx[i]
      ny=y+dy[i]
      if nx>=0 and ny>=0 and nx<l and ny<l:
        if graph[nx][ny]<=size and visited[nx][ny]>visited[x][y]+1:
          visited[nx][ny]=visited[x][y]+1 
          queue.append((nx,ny))
          
       
  return visited[a][b]
 
n=int(input())
size=2
eatNum=0
graph=[]
for _ in range(n):
  graph.append(list(map(int,input().split())))

#아기상어의 초기 위치
pos=[0,0]
for i in range(n):
  for j in range(n):
    if graph[i][j]==9:
      pos[0]=i
      pos[1]=j
time=0
visited=[[1e9]*n for _ in range(n)]
while True:
  temp=[]
  for i in range(n):
    for j in range(n):
      if graph[i][j]<size and graph[i][j]>0:
        temp.append((abs(i-pos[0])+abs(j-pos[1]),i,j))
  #temp.sort(key=lambda x :(x[0],x[1],x[2]))
  food=[]
  for dis,x,y in temp:
    distance=canGo(x,y,size)
    if distance!=-1 and distance<1e9:
      food.append((distance,x,y))
       
  food.sort(key=lambda x :(x[0],x[1],x[2]))
   
  if len(food)==0:
    break
  
  eatNum+=1
  if eatNum==size:
    size+=1
    eatNum=0
  graph[food[0][1]][food[0][2]]=9
  graph[pos[0]][pos[1]]=0
  pos[0]=food[0][1]
  pos[1]=food[0][2]
  time+=food[0][0]
   
   
print(time)
    
      
