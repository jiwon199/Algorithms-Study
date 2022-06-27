#백준 2630
import sys
sys.setrecursionlimit(10 ** 6)
def check(sx,sy,size):
  color=graph[sx][sy]
  for i in range(sx,sx+size):
    for j in range(sy,sy+size):
      if graph[i][j]!=color:
        return -1
  return color
def devide(sx,sy,size):
  #현재 사이즈만큼의 크기를 확인해서 모두 같은색이면 +=1
  color=check(sx,sy,size)
  if color==1:
    blue[0]+=1
  elif color==0:
    white[0]+=1
  else:   
    half=size//2
    devide(sx,sy+half,half)
    devide(sx,sy,half)
    devide(sx+half,sy,half)
    devide(sx+half,sy+half,half)
n=int(input())
graph=[]
white=[0]
blue=[0]
for _ in range(n):
  graph.append(list(map(int,input().split())))
devide(0,0,n)
print(white[0])
print(blue[0])
