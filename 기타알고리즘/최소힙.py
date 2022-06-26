import heapq
import sys
q=[]
n=int(sys.stdin.readline())
l=0
for _ in range(n):
  number=int(sys.stdin.readline())
  if number==0:
    if l==0:
      print(0)
    else:
      print(heapq.heappop(q))
      l-=1
      
  else:
    heapq.heappush(q,number)
    l+=1
    
