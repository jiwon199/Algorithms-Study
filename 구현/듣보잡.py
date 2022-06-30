from collections import defaultdict
data1=defaultdict(int)
data2=defaultdict(int)
n,m=list(map(int,input().split()))
name=set()
for _ in range(n):
  word=input()
  data1[word]+=1
  name.add(word)
for _ in range(m):
  word=input()
  data2[word]+=1
  name.add(word)
answer=[]
for word in name:
  if data1[word]==1 and data2[word]==1:
    answer.append(word)
print(len(answer))
answer=sorted(answer)
for ans in answer:
  print(ans)
    
  
 
