#부스트캠프 자가진단 문제 1번
from collections import defaultdict
arr=list(map(int,input().split()))
data=defaultdict(int)
for num in arr:
  data[num]+=1
answer=[]
for key in data.keys():
  if data[key]>=2:
    answer.append(data[key])
if len(answer)==0:
  answer.append(-1)
print(answer)
'''
1 2 3 3 3 3 4 4
답: [4,2]

3 2 4 4 2 5 2 5 5
답 [3, 2, 3]

3 5 7 9 1
답 -1
'''
