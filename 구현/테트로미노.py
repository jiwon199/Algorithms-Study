#백준 14500
def checkScore(tet,board,h,w):
  score=0
  for i in range(h):
    for j in range(w):      
      tempPos=set()
      tempScore=0
      #tet의 모든 좌표에 i,j를 더하는데, 만약 board를 넘어가는 좌표가 있다면 그 tet은 탈락
      for x,y in tet:
        nx=x+i
        ny=y+j
        if nx<h and ny<w:
          tempPos.add((nx,ny))
      if len(tempPos)>=4:
        for a,b in tempPos:
          tempScore+=board[a][b]          
        score=max(tempScore,score)
                      
  return score
 
#총 19가지의 경우 (좌표로 저장)
tets=[
  [(0,0),(0,1),(0,2),(0,3)],
  [(0,0),(1,0),(2,0),(3,0)],
  [(0,0),(0,1),(1,0),(1,1)],
  [(0,0),(1,0),(2,0),(2,1)],
  [(0,1),(1,1),(2,1),(2,0)],
  [(0,0),(0,1),(0,2),(1,0)],
  [(0,0),(0,1),(0,2),(1,2)],
  [(0,0),(0,1),(1,1),(2,1)],
  [(0,0),(0,1),(1,0),(2,0)],
  [(1,0),(1,1),(1,2),(0,2)],
  [(0,0),(1,0),(1,1),(1,2)],
  [(0,0),(1,0),(1,1),(2,1)],
  [(0,1),(1,1),(1,0),(2,0)],
  [(1,0),(1,1),(0,1),(0,2)],
  [(0,0),(0,1),(1,1),(1,2)],
  [(0,1),(1,0),(1,1),(1,2)],
  [(0,0),(1,0),(1,1),(2,0)],
  [(0,0),(0,1),(0,2),(1,1)],
  [(0,1),(1,0),(1,1),(2,1)]
]

h,w=list(map(int,input().split()))
board=[]
for _ in range(h):
  board.append(list(map(int,input().split())))
scores=[]
for t in tets:
  scores.append(checkScore(t,board,h,w))
print(max(scores))
