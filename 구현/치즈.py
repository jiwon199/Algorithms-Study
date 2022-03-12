#백준 2638
n,m=list(map(int,input().split()))
graph=[]
for i in range(n):
  graph.append(list(map(int,input().split())))

   
dx=[-1,1,0,0]
dy=[0,0,-1,1]
day=0
def check(n,m,row,col):
  res=0
  for i in range(4):
    nx=row+dx[i]
    ny=col+dy[i]
    if nx<n and ny<m and nx>=0 and ny>=0:
      if graph[nx][ny]==1:
        res+=1
         
  if res!=4:
    graph[row][col]=-1

 
for i in range(n):
  for j in range(m):
    if graph[i][j]==0:
      check(n,m,i,j)
 
while True:
  arr=[] 
  for i in range(n):
    for j in range(m):
      if graph[i][j]==1:
        count=0
        for k in range(4):
          nx=i+dx[k]
          ny=j+dy[k]
          if nx>=0 and ny>=0 and nx<n and ny<m:
            if graph[nx][ny]==-1:
              count+=1
        if count>=2:
          arr.append((i,j))
          
  if len(arr)==0:
    break
  for pos in arr:
    graph[pos[0]][pos[1]]=0
    check(n,m,pos[0],pos[1])
  day+=1
        
print(day)
