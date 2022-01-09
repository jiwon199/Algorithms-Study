#이코테 201p 이진탐색 실전문제2
'''
입력 예제
4 6
19 15 10 17
'''
n,m=list(map(int,input().split()))
array=list(map(int,input().split()))

start=0
end=max(array)

result=0

while start <=end:
  mid=(start+end)//2
  total=0

  for i in array:
    if i>mid:
      total+=i-mid
  
  if total<m:
    end=mid-1
  else:
    start=mid+1
    result=mid
    

print(result)
