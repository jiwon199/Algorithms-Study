import heapq
#백준 10282
#감염된 컴퓨터 수, 의존관계 수,감염된 컴퓨터 번호
def getTime(n,d,infected,computer,dp):
  count=0
  q=[]
  heapq.heappush(q,(0,infected))
  time=0
  dp[infected] = 0
  while q:
    t,c=heapq.heappop(q)
    count+=1
    for next in computer[c]:
      if dp[next[1]]>t+next[0]:
        heapq.heappush(q,(t+next[0],next[1]))
        dp[next[1]]=t+next[0]
   
def clearComputer(computer):
  for i in range(10001):
    computer[i]=[]
    
computer=[[] for _ in range(10001)]
test_case=int(input())
for _ in range(test_case):
  n,d,infected=list(map(int,input().split()))
  for i in range(d):
    a,b,s=list(map(int,input().split()))
    computer[b].append((s,a))    
    dp = [1e9] * (n + 1)
  getTime(n,d,infected,computer,dp)
  cnt = 0
  ans = 0
  for i in dp:
      if i != 1e9:
        cnt += 1
        ans = max(ans, i)
  print(cnt,ans)
  clearComputer(computer)
