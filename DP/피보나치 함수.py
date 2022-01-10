#백준 1003
def Fibo(k):
  if dp[k]!=-1:
    return dp[k]
  elif k==0:           
    return 0
  elif k==1:   
    return 1
  else:  
    dp[k]=Fibo(k-1)+Fibo(k-2)    
    res[k][0]=res[k-1][0]+res[k-2][0]
    res[k][1]=res[k-1][1]+res[k-2][1] 
    return dp[k]

n=int(input())
array=[]
 
for i in range(n):  
  array.append(int(input()))
  
dp=[-1]*41
 
res=[[-1,-1] for i in range(41)] 
res[0][0]=1  
res[0][1]=0  
res[1][0]=0    
res[1][1]=1
 
for i in array:  
    
   Fibo(i)
   print(res[i][0],res[i][1])
 
