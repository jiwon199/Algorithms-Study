#백준 2231
n=int(input())
flag=False
for i in range(n):
  num=str(i)
  temp=0
  for number in num:
    temp+=int(number)
   
  if temp+i==n:
    print(i)
    flag=True
    break
if flag==False:
  print(0)
