#백준 1654
 
n,m=list(map(int,input().split()))
array=[]

for i in range(n):
  array.append(int(input()))

start=0
end=max(array)
result=0

while start<=end:
  mid=(start+end)//2 

  #0이면 1로 올려주기!
  if mid==0:
    mid=1 
  total=0  
  for x in array:
    if x>=mid :
      total+=x//mid
   
  if total<m:
    end=mid-1
  else:
    start=mid+1
    result=mid
    
print(result)
