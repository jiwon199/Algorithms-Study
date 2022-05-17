n,m=list(map(int,input().split())) #데이터의 갯수, 부분합 M
data=list(map(int,input().split())) #전체 수열

count=0
interval_sum=0
end=0

#start를 차례대로 증가시키며 반복
#start 증가=interval_sum 감소
for start in range(n):
  #해당 start를 고정시켜놓고, end를 가능한만큼 이동시키기
  while interval_sum<m and end<n:
    interval_sum+=data[end]
    end+=1
  #부분합이 m일때 카운트 증가
  if interval_sum==m:
    count+=1
  #for문 돌면서 start를 1 증가시킬거니까 다음 반복문을 위해 마이너스
  interval_sum-=data[start]
  
print(count)
