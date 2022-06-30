import copy
graph=[[None]*4 for _ in range(4)]
direction=[(-1,0),(-1,-1),(0,-1),(1,-1),(1,0),(1,1),(0,1),(-1,1)]
for i in range(4):
  arr=list(map(int,input().split()))
  for j in range(4):
    #물고기 번호, 방향 순으로 기록
    #graph[i].append([arr[i],arr[i+1]-1])
    graph[i][j]=[arr[j*2],arr[j*2+1]-1]
def turn_left(d):
  return (d+1)%8
#
def find_fish(graph,number):
  for i in range(4):
    for j in range(4):
      if graph[i][j][0]==number:
        return [i,j]
  return None
  
def move_fish(graph,x,y):
  for i in range(1,17):
    pos=find_fish(graph,i)
    if pos!=None:
      dir=graph[pos[0]][pos[1]][1]
      for j in range(8):
        nx=direction[dir][0]+pos[0]
        ny=direction[dir][1]+pos[1]
        if nx>=0 and ny>=0 and nx<4 and ny<4:
          if not(nx==x and ny==y):
             
            graph[pos[0]][pos[1]][1]=dir
            graph[pos[0]][pos[1]],graph[nx][ny]=graph[nx][ny],graph[pos[0]][pos[1]]
            break
        dir=turn_left(dir)
           
    
  return
def move_shark(graph,x,y):
  position=[] #갈 수 있는 모든 칸을 position에 저장
  dir=graph[x][y][1]
  for i in range(4):
    x=x+direction[dir][0]
    y=y+direction[dir][1]
    if x>=0 and y>=0 and x<4 and y<4:
      if graph[x][y][0]!=-1:
        position.append((x,y))
  return position
  
def dfs(graph,x,y,total):
  global result
  graph=copy.deepcopy(graph)
  
  #현재 위치의 물고기 먹고, 그 위치는 상어가 차지.
  total+=graph[x][y][0]
  #x,y위치가 아닌데 -1값을 가지는 애들은 상어가 먹고 자리를 뜬 빈 칸.
  graph[x][y][0]=-1 #graph[x][y][1]이 방향

  move_fish(graph,x,y)
  position=move_shark(graph,x,y)
  if len(position)==0:
    result=max(result,total)
    return
  for nx,ny in position:
    dfs(graph,nx,ny,total)

result=0
dfs(graph,0,0,0)
print(result)
