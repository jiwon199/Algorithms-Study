#이코테 96p 그리디 실전문제2
n,m=list(map(int,input().split()))

maxres=0
for i in range(n):  
  x=list(map(int,input().split()))
  minval=min(x)    
  if minval >maxres:
    maxres=minval

print(maxres)
