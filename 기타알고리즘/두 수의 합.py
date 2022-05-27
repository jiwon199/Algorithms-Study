#백준3273  
n=int(input())
data=list(map(int,input().split()))
x=int(input())
data=sorted(data)
start=0
end=n-1
count=0

while start<end:
  val=data[start]+data[end]  
  if val==x:
    count+=1
    start+=1
  elif val<x:
    start+=1
  elif val>x:
    end-=1
    
print(count)
