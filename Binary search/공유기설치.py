import sys
#백준 2110
n,m=list(map(int,sys.stdin.readline().split()))
arr=[]
for i in range(n):
  arr.append(int(sys.stdin.readline()))
arr=sorted(arr)
#start,end를 위치가 아니라 거리를 기준으로 해야됨!
#거리를 탐색 한다고 생각하면 편한듯.
start=1 #최소거리
end=arr[-1]-arr[0] #최대거리
restul=0
if m==2:
  result=arr[-1]-arr[0]
else:
  while start<end:
   
    mid=(start+end)//2 #mid가 최소간격이라 치면..
    count = 1
    last=arr[0] #마지막으로 설치된 공유기의 위치
    #간격이 mid 이상일때만 설치하고 count++
    for i in range(n):
      if arr[i] - last >= mid:
        count+=1
        last = arr[i]
    if count >= m:
      result = mid
      start = mid + 1
    else:
      end = mid
print(result)



