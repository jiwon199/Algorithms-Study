from collections import defaultdict
n=int(input())
data=defaultdict(int)
key=set()
for _ in range(n):
  temp=input().split('.')
  data[temp[1]]+=1
  key.add(temp[1])

key=sorted(key)  

for k in key:
  print(k,data[k])
