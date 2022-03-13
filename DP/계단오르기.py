arr=[]
n=int(input())
for i in range(n):
  arr.append(int(input()))

if n==1:
  print(arr[0])
elif n==2:
  print(arr[0]+arr[1])
else:
  dp=[arr[0],arr[0]+arr[1],max(arr[0]+arr[2],arr[1]+arr[2])]
  for i in range(3,n):
    temp=max(arr[i]+arr[i-1]+dp[i-3],arr[i]+dp[i-2])
    dp.append(temp)

  print(dp[-1])
