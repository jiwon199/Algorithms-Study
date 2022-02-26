#백준 14889
from itertools import permutations
from itertools import combinations
n=int(input())
graph=[]
for _ in range(n):
  graph.append(list(map(int,input().split())))
people=[i for i in range(n)]

data=list(combinations(people,n//2))
k=len(data)
teams=[] 
for i in range(k//2):
  temp=[data[i],data[-i-1]]
  teams.append(temp)

res=[]
for team in teams:
  score1=list(permutations(team[0],2))
  sum1=0
  for s in score1:
    sum1+=graph[s[0]][s[1]]
  score2=list(permutations(team[1],2))
  sum2=0
  for s in score2:
    sum2+=graph[s[0]][s[1]]
  res.append(abs(sum1-sum2))
print(min(res))
  
  
