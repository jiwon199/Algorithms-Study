#백준 2493
n=int(input())
arr=list(map(int,input().split()))
count=0
data=[]
for i in range(n):
  data.append((i+1,arr[i]))

ans=[0]*n
#스택에는 길이가 아니라 index를 저장
stack=[]  
for i in range(n):
  topLength=arr[i]
  #왼쪽에 있는 놈이 현재 탑 길이보다 작고, 스택이 비지 않았으면
  while stack and arr[stack[-1]] < topLength:
    #현재 탑 높이에 걸려 왼쪽의 짤뚱한 뇨속에게는 레이저가 어차피 닿지 않음. 스택에서 지워준다.
    stack.pop()
  #이 while문 탈출했을때 stack의 마지막 원소가 현재탑의 레이저가 닿는 탑의 번호. 단, 스택에 원소가 있을 때에만..
  if stack:
    ans[i]=stack[-1]+1
  #다음 탑이 나를 검사할 수 있도록 스택에 추가..
  stack.append(i)

for a in ans:
  print(a,end=' ')
 
 


 
  
