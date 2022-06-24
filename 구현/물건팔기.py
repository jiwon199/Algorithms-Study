def getBenefit(money,arr):
  sum=0
  for info in arr:
    #책정한 비용을 낼 의사가 있으면
    if info[0]>=money:
      if money>info[1]:
        sum+=money
        sum-=info[1]
      
  if sum>=0:
    return sum
  else:
    return 0
   
n=int(input())
arr=[(0,0)]
for _ in range(n):
  a,b=list(map(int,input().split()))
  arr.append((a,b))
benefit=[]
arr=sorted(arr)
minMoney=arr[0][0]
maxMoney=arr[-1][0]
 
for i in range(minMoney,maxMoney+1):
  benefit.append((getBenefit(i,arr),i))
 
benefit.sort(key=lambda x : (-x[0],x[1]))
print(benefit[0][1])
