#백준 1931
n=int(input())
meeting=[]
for _ in range(n):
    start,end=map(int,input().split())
    meeting.append((start,end))
 
#정렬 조건1- 종료 시간 ,정렬조건2- 시작 시간
meeting.sort(key=lambda x:(x[1],x[0]))
 
#이전 회의의 종료 시간이 다음 회의의 시작 시간과 같거나 작으면 카운트
count=0
beforeEnd=-1
for i in range(n):  
  if beforeEnd <= meeting[i][0]:
    count+=1   
    beforeEnd=meeting[i][1]
     
print(count)
