#백준 18353
n=int(input())
arr=list(map(int,input().split()))
dp=[1]*(n+1)
arr.reverse()
for i in range(1,n):
   for j in range(0,i):
     if arr[j]<arr[i]:
       dp[i]=max(dp[i],dp[j]+1) 


print(n-max(dp))
    
    
