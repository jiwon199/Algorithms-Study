#백준 11399
n=int(input())
x=list(map(int,input().split()))
x.sort()
res=0
for i in range(n):
    res+=x[i]*(n-i)
        
print(res)
