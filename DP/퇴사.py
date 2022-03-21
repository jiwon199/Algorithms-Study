#백준 14501
n=int(input())
times=[]
pays=[]
for i in range(n):
  time,pay=list(map(int,input().split()))
  times.append(time)
  pays.append(pay)
dp=[0]*(n+1)
answer=0

for i in range(n-1,-1,-1):
  time=i+times[i] 
  if time<=n:
    dp[i]=max(dp[time]+pays[i],answer)
    answer=dp[i]
  else:
    dp[i]=answer

print(answer)
