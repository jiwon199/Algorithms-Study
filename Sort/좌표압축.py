#백준 18870
n=int(input())

original=[]
sortarray=[]
indexarray=[0]*n
 
original=list(map(int,input().split()))
sortarray=sorted(original)

res={}
res[sortarray[0]]=0
for i in range(1,n):
  if sortarray[i-1]==sortarray[i]:
    indexarray[i]=indexarray[i-1]   
  else:
    indexarray[i]=indexarray[i-1]+1
  res[sortarray[i]]=indexarray[i]
     
for i in original:
  print(res[i],end=' ')
  
