n,k=list(map(int,input().split()))
items=[(0,0)]
W=[0]
V=[0]
for i in range(n):
  w,v=list(map(int,input().split())) #무게,가치
  W.append(w)
  V.append(v)
dp=[[0]*(k+1) for _ in range(n+1)]
 
for item in range(1,n+1):  
  for kg in range(1,k+1):   
    if W[item]>kg:
      dp[item][kg]=dp[item-1][kg]
    else:
      dp[item][kg]=max(dp[item-1][kg], V[item]+dp[item-1][kg-W[item]])
print(dp[n][k])
