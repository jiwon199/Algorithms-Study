#백준 14499
def roll(direction,state):
  a=state[0]
  b=state[1]
  c=state[2]
  d=state[3]
  e=state[4]
  f=state[5]
  if direction==1:
    state=[c,a,f,d,e,b]
  elif direction==2:
    state=[b,f,a,d,e,c]
  elif direction==3:
    state=[d,b,c,f,a,e]
  else:
    state=[e,b,c,a,f,d]
  return state
   
n,m,x,y,k=list(map(int,input().split()))
graph=[]
for _ in range(n):
  graph.append(list(map(int,input().split())))
move=list(map(int,input().split()))
dice=dict()
 
#상단, 상단의 오른쪽, 상단의 왼쪽, 상단의 아래, 상단의 위,바닥 순서
state=[1,3,4,5,2,6]
number=dict() #각 면에 적힌 숫자
for i in range(1,7):
  number[i]=0
#동 서 북 남
direction=[(0,1),(0,-1),(-1,0),(1,0)]
currentSide=1 #현재 윗면 1
 
for dir in move:
  nx=x+direction[dir-1][0]
  ny=y+direction[dir-1][1]
   
  if nx>=0 and ny>=0 and nx<n and ny<m:
    state=roll(dir,state)
    currentSide=state[0]
    underSide=state[5]#현재 아랫면
    if graph[nx][ny]==0:
      graph[nx][ny]=number[underSide]
      
    else:
      number[underSide]=graph[nx][ny]
      graph[nx][ny]=0
         
    print(number[currentSide])
    x=nx
    y=ny
   
