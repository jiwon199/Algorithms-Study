import heapq
import sys
from collections import defaultdict
def pop(data,q,state):
  res=None
  while True:
    info=heapq.heappop(q)
    k=info[0]
    if state==-1:
      k=-info[0]
    if data[info[1]]==1:
      data[info[1]]=0
      res=k
      break
  return res
     
def test_case(n):
  minq=[]
  maxq=[]
  length=0
  data=defaultdict(int)
  for i in range(n):
    arr=sys.stdin.readline().split()
    oper=arr[0]
    number=int(arr[1])
    if oper=='I':
      heapq.heappush(minq,(number,i))
      heapq.heappush(maxq,(-number,i))
      data[i]=1
      length+=1
    else:
      if length>=1:
        #최대값 삭제
        if number==1:
          pop(data,maxq,-1)   
        #최소값 삭제
        else:
          pop(data,minq,1)
        length-=1
  if length==0:
    print("EMPTY")
  elif length==1:
    popNum=pop(data,minq,1)
    print(popNum,popNum)
  else:
    popNum1=pop(data,maxq,-1)
    popNum2=pop(data,minq,1)
    print(popNum1,popNum2)
    
    
           
tc=int(sys.stdin.readline())
for _ in range(tc):
  n=int(sys.stdin.readline())
  test_case(n)
       
