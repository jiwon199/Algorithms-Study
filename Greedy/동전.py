# 백준11047
n,k=list(map(int,input().split()))

x=[]
for i in range (n):
    x.append(int(input()))

x.sort(reverse=True)
count=0
for money in x:
    if money <= k:
        count+=k//money
        k=k%money
        
print(count)
