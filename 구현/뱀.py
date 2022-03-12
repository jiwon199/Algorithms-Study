#백준 3190  
#왼쪽 회전이면 +1 오른쪽 회전이면 -1
#오,위,왼,아
direction=[(0,1),(-1,0),(0,-1),(1,0)]
n=int(input())
graph=[[0]*n for _ in range(n)]
m=int(input())
for _ in range(m):
  a,b=list(map(int,input().split()))
  graph[a-1][b-1]=1

k=int(input())
move=[]
for _ in range(k):
  a,b=list(input().split())
  move.append((int(a),b))

x=0
y=0
now=0
time=0
graph[x][y]=2
arr=[[0,0]]
while True:
  nx=x+direction[now][0]
  ny=y+direction[now][1]

  time+=1
  if nx<0 or ny<0 or nx>=n or ny>=n:
    break
  if graph[nx][ny]==2:
    break
  if graph[nx][ny]==1:
    graph[nx][ny]=2    
  else:
    graph[nx][ny]=2
    graph[arr[0][0]][arr[0][1]]=0
    arr.pop(0)
  arr.append((nx,ny))
  x=nx
  y=ny
  if len(move)>0:
    if time==move[0][0]:
      if move[0][1]=='L':
        now+=1
        if now==4:
          now=0
      else:
        now-=1
        if now==-1:
          now=3
      move.pop(0)
   
    
print(time)
  
