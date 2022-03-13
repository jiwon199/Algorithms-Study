#백준 2580
import sys
sys.setrecursionlimit(10**8)
 
row=[[0]*10 for _ in range(9)]
col=[[0]*10 for _ in range(9)]
area=[[0]*10 for _ in range(9)]
blank_cord=[]


def find_area(i,j):
  return 3*(i//3)+(j//3)

def dfs(k,n,answer):
  if k==n:
    return True
  i,j=blank_cord[k]
  a=find_area(i,j)
  for x in range(1,10):
    if row[i][x]==0 and col[j][x]==0 and area[a][x]==0:
       
      row[i][x]=1
      col[j][x]=1
      area[a][x]=1
      
      answer[i][j]=x
      if dfs(k+1,n,answer)==True:
        return True
    
      row[i][x]=0
      col[j][x]=0
      area[a][x]=0
 
  return False

 
sudoku = [list(map(int, input().split())) for _ in range(9)]
answer=[[0]*9 for _ in range(9)]
for i in range(9):
  for j in range(9):
    if sudoku[i][j]==0:
      blank_cord.append((i,j))      

    else:
      row[i][sudoku[i][j]]=1
      col[j][sudoku[i][j]]=1
      area[find_area(i,j)][sudoku[i][j]]=1
      answer[i][j]=sudoku[i][j]

dfs(0,len(blank_cord),answer)
for line in answer:
    for num in line:
       print(num, end=' ')
    print()
