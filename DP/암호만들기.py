code=input()
n=len(code)
dp = [0] * (n+1)	
flag=False
if (code[0] == '0'):  
  flag=True 
dp[0] = dp[1] = 1
	
for i in range(2,n+1):
  cur=i-1
  if code[cur]=='0' and (code[cur-1]<'1' or code[cur-1]>'2'):
    flag=True
  if code[cur]!='0':
    dp[i]+=dp[i-1]
  if code[cur-1]=='1' or (code[cur-1]=='2' and code[cur]<='6'):
    dp[i]+=dp[i-2]
  
answer = dp[n]
if flag==True:
  print(0)
else:
  print(answer%1000000)

	 
