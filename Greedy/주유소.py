#백준 13305
n=int(input())
length=list(map(int,input().split()))
money=list(map(int,input().split()))
#4
#2 3 1
#5 2 4 1

res=0
minMoney=money[0]
for i in range (len(money)-1):
     
    if money[i]<minMoney:
      minMoney=money[i]      
    res+=minMoney*length[i]
  
print(res)
