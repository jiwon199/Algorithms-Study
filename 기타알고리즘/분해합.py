#백준 2231
n=int(input())
answer=0
for i in range(n):
  num=str(i)
  temp=0
  for j in num:
    temp+=int(j)
  temp+=i
  if temp==n:
    answer=i
    break
print(answer)
  
