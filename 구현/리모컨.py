from itertools import product
def makeCase(data,res):
  for r in res:
    temp=''
    for i in r:
      temp+=str(i)
    data.add(int(temp))
channel=int(input())
broken=int(input())
answer=abs(channel-100)
 
if broken==0:
  answer=min(len(str(channel)),answer)
elif channel==100:
  answer=0
  brokenNum=list(map(int,input().split()))
else:
  brokenNum=list(map(int,input().split()))
  number=[0,1,2,3,4,5,6,7,8,9]
  for num in brokenNum:
    number.remove(num)
  n=len(str(channel))
  
  data=set()
     
  res1=list(product(number,repeat=n))    
  res2=list(product(number,repeat=n+1))
  makeCase(data,res1)
  makeCase(data,res2)
  if n>1:
    res3=list(product(number,repeat=n-1))
    makeCase(data,res3)
  
    
  for num in data:
    answer=min(answer,abs(channel-num)+len(str(num)))
   
print(answer)
