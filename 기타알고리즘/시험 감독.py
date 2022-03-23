#백준 13458
import math
n=int(input())
A=list(map(int,input().split()))
b,c=list(map(int,input().split()))
 
number=n

for i in range(n):
  temp=math.ceil((A[i]-b)/c)
  if temp>0:
    number+=temp
  
print(number)
  
