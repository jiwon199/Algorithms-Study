def check(x,y,size):
  color=graph[x][y]
  flag=True
  for i in range(x,x+size):
    for j in range(y,y+size):
      if graph[i][j]!=color:
        flag=False
      
  return flag

def dfs(size,x,y):
  if check(x,y,size)==True:
    result[graph[x][y]]+=1
     
    return
  else:
    size=size//3
    dx=[x,x+size,x+2*size]
    dy=[y,y+size,y+2*size]
    for nx in dx:
      for ny in dy:
        dfs(size,nx,ny)
    
    
    
result=dict()
result[0]=0
result[1]=0
result[-1]=0
graph=[]
n=int(input())
for i in range(n):
  arr=list(map(int,input().split()))
  graph.append(arr)
dfs(n,0,0)
 
print(result[-1])
print(result[0])
print(result[1])
