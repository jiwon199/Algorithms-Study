from collections import defaultdict
import sys
#백준 22233
memo= defaultdict(int)
n,m=list(map(int,sys.stdin.readline().split()))
 
for _ in range(n):
  word=sys.stdin.readline().strip()
  memo[word]=1
count=0
 
for _ in range(m):
  temp=list(sys.stdin.readline().strip().split(',') )
  for t in temp:
    if memo[t]!=0:
      if memo[t]==1:
        count+=1
      memo[t]+=1     
  print(n-count)
 
