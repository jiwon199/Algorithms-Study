#백준 2292
dp=[1]
n=int(input())
if n==1:
  print(1)
else:
  for i in range(1,n):
    temp=dp[i-1]+6*i
    dp.append(temp)
    if temp>=n:
      print(i+1)
      break
  
