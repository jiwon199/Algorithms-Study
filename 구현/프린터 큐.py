import heapq
from collections import deque
#백준 1966
def findSeq(index,arr):
  queue=deque()
  priorityQ=[]
  
  for i in range(len(arr)):
     queue.append((arr[i],i))      
     heapq.heappush(priorityQ,-arr[i])
  count=0
  while queue:
    item=queue.popleft()
    top=heapq.heappop(priorityQ)
    if item[0]==abs(top):
      count+=1
      if item[1]==index:
        break
    else:
      queue.append(item)
      heapq.heappush(priorityQ,top)   
  return count
 
test=int(input())
for _ in range(test):
  a,b=list(map(int,input().split()))
  arr=list(map(int,input().split()))
  print(findSeq(b,arr))
