#백준 21608
def whereStudent(student,bestFriends):
   
  #count, blank, i, j 순으로 저장하자
  position=[]
  dx=[-1,1,0,0]
  dy=[0,0,-1,1]
  for i in range(n):
    for j in range(n):
      count=0
      blank=0
      #인접 칸을 체크...
      for k in range(4):
        nx=i+dx[k]
        ny=j+dy[k]
        if nx>=0 and ny>=0 and nx<n and ny<n:
           if board[nx][ny]==0:
             blank+=1
           else:
             if isThereBestFriend(nx,ny,bestFriends)==True:
               count+=1
      position.append([count,blank,i,j])

  res=[]
  for pos in position:
    x=pos[2]
    y=pos[3]
    if board[x][y]==0:
      res.append(pos)
  res=sorted(res,key=lambda x: (-x[0],-x[1],x[2],x[3]))
  board[res[0][2]][res[0][3]]=student
  
  return position
                          
def isThereBestFriend(x,y,bestFriends):
  if board[x][y] in bestFriends:
    return True
  else:
    return False
  
def checkScore(x,y,bestFriends):
  dx=[-1,1,0,0]
  dy=[0,0,-1,1]
  count=0
  for i in range(4):
    nx=x+dx[i]
    ny=y+dy[i]
    if nx>=0 and ny>=0 and nx<n and ny<n:
      if board[nx][ny] in bestFriends:
        count+=1
  if count==0:
    return 0
  elif count==1:
    return 1
  elif count==2:
    return 10
  elif count==3:
    return 100
  else:
    return 1000
        
  
data=dict() #좋아하는 학생 정보입력
n=int(input())
for i in range(n*n):
  temp=list(map(int,input().split()))
  data[temp[0]]=temp[1:]

board=[[0]*n for _ in range(n)]
keyStudent=data.keys()
for k in keyStudent:
  whereStudent(k,data[k])

answer=0
for i in range(n):
  for j in range(n):
    answer+=checkScore(i,j,data[board[i][j]])
print(answer)
