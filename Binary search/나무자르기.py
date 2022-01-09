import sys
#백준 2805
n,m=list(map(int, sys.stdin.readline().split()))
array=list(map(int,sys.stdin.readline().split()))

start=0
end=max(array)
result=0

while start<=end:
  mid=(start+end)//2 
  total=0  
  '''
  이렇게 모든 array를 돌며 더하면 시간 초과
  for x in array:
    if x>=mid :
      total+=x-mid
  '''
  total=sum([i-mid if mid < i else 0 for i in array])   
  if total<m:
    end=mid-1
  else:
    start=mid+1
    result=mid
    
print(result)
