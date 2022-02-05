#백준 1026
n=int(input())
A=list(map(int,input().split()))
B=list(map(int,input().split()))
B=sorted(B,reverse=True)
A=sorted(A)
s=0
for i in range(n):
   s+=A[i]*B[i]
print(s)
