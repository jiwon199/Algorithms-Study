#백준 11279
import heapq
from sys import stdin
que=[]
n=int(stdin.readline())
arr=[]
for i in range(n):
  k=int(stdin.readline())
  if k!=0:
    heapq.heappush(que,-k)
  elif not que:
    print(0)
  else:   
    print(-heapq.heappop(que))
