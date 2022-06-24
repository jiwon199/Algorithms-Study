#백준 20920
from collections import defaultdict
n,m=list(map(int,input().split()))
data=defaultdict(int)
for i in range(n):
  word=input()
  if len(word)>=m:
    data[word]+=1
arr=[]
for key in data:
  arr.append((data[key],len(key),key))
  
arr.sort(key=lambda x :(-x[0],-x[1],x[2]))
for a in arr:
  print(a[2])
