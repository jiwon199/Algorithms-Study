#백준 1806
#합이 s 이상인 가장 짧은 수열의 길이 구하기!
n,s=list(map(int,input().split())) #데이터의 갯수, 부분합 M
data=list(map(int,input().split())) #수열 데이터

end=0
interval_sum=0  
answer=n+1 #길이
 
for start in range(n):
  while end<n and interval_sum<s:   
    interval_sum+=data[end]
    end+=1
  if interval_sum>=s:
    answer=min(answer,end-start)
     
  interval_sum-=data[start]
 
if answer==n+1:
  print(0)
else:
  print(answer)
