#백준14503
import copy
def getLeftIndex(dir):
  newDir=dir
  if dir==0:
    newDir=3
  else:
    newDir=dir-1
  return newDir
def getBackIndex(dir):
  return (dir+2)%4
  
n,m=list(map(int,input().split()))
rx,ry,d=list(map(int,input().split()))
#벽1 빈칸0 로봇청소기2  
graph=[]

for _ in range(n):
  graph.append(list(map(int,input().split())))

#벽은 그대로 1로 두고, 청소한칸은 -1
visited=copy.deepcopy(graph)
graph[rx][ry]=2
visited[rx][ry]=-1
#0북/ 1동/2남/3서
direction=[(-1,0),(0,1),(1,0),(0,-1)]
moved=[(rx,ry)]
count=0 #청소한 칸의 갯수
while True:
  cx=moved[-1][0]
  cy=moved[-1][1]
  foundBlank=False  
  isBreak=False
  #왼쪽으로 한번씩 돌기.  
  for i in range(4):
    leftD=getLeftIndex(d)
    lx=cx+direction[leftD][0]
    ly=cy+direction[leftD][1]
    if lx>=0 and ly>=0 and lx<n and ly<m:     
      #왼쪽이 빈칸이면 왼쪽으로 회전 후 for문 탈출
      if graph[lx][ly]==0 and visited[lx][ly]!=-1:
        d=leftD
        foundBlank=True
        break
      #아니면 왼쪽으로 회전만
      elif foundBlank==False:
        d=leftD
        
  #빈칸 못찾고 회전만 4번 했을시
  if foundBlank==False:
    backD=getBackIndex(d)
    bx=cx+direction[backD][0]
    by=cy+direction[backD][1]
    if bx>=0 and by>=0 and bx<n and by<m:    
      #뒤를 확인하고 벽이라면 탈출 플래그를 트루로
      if graph[bx][by]==1:
        isBreak=True
      #아니라면 후진을..
      else:
        moved.append((bx,by))
        graph[bx][by]=2
        graph[cx][cy]=0
      
    #후진했다가 그래프 밖으로 나가버리는 상황이어도 탈출 플래그를 트루로
    else:
      isBreak=True
  #빈칸 찾은 경우.
  else:
    nx=cx+direction[d][0]
    ny=cy+direction[d][1]
    if visited[nx][ny]==0:
      visited[nx][ny]=-1

    graph[nx][ny]=2
    graph[cx][cy]=0
    moved.append((nx,ny))

  #탈출조건 확인
  if isBreak==True:
    break

for i in range(n):
  for j in range(m):
    if visited[i][j]==-1:
      count+=1
print(count)
    
          
   
    
  
