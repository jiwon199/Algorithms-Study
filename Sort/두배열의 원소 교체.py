#이코테 182p 정렬 실전문제3
n,k=list(map(int,input().split()))
A=[]
B=[]
A=list(map(int,input().split()))
B=list(map(int,input().split()))

A=sorted(A)
B=sorted(B,reverse=True)

for i in range(k):
  if A[i]<B[i]:
    A[i],B[i]=B[i],A[i]
  else:
    break
  
print(sum(A))
