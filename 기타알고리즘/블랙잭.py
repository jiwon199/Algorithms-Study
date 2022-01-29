#백준 2798
from itertools import combinations
n,m=list(map(int,input().split()))
arr=list(map(int,input().split()))
res=list(combinations(arr,3))
ans=[]
for i in res:
  tmp=sum(i)
  if tmp<=m:
    ans.append(tmp)

print(max(ans))
