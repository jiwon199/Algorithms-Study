#백준 15686
from itertools import combinations
#치킨집 조합과 집 위치 하나가 지정됐을때 그 집의 치킨거리 반환
def calRange(chicken,home):
  temp=[]
  for c in chicken:
    temp.append(abs(home[0]-c[0])+abs(home[1]-c[1]))
  return min(temp)


n,m=list(map(int,input().split()))
graph=[]
for i in range(n):
  temp=list(map(int,input().split()))
  graph.append(temp)

num=0 #치킨집갯수
chicken=[]
house=[]
for i in range(n):
  for j in range(n):
    if graph[i][j]==2:
      num+=1
      chicken.append((i,j))
    elif graph[i][j]==1:
      house.append((i,j))

data=list(combinations(chicken,m))
ans=[]  
 
for d in data:
  sum=0
  for h in house:
    sum+=calRange(d,h)
  ans.append(sum)
   
print(min(ans))
