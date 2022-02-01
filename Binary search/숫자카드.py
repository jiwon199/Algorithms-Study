#백준 10815
def search(start,end,t,arr):
  if start>end:
    return 0
  mid=(start+end)//2
  if arr[mid]==t:
    return 1
  if arr[mid]>t:
    return search(start,mid-1,t,arr)
  else:
    return search(mid+1,end,t,arr)
   
n=int(input())
arr=list(map(int,input().split()))
arr=sorted(arr)
m=int(input())
targets=list(map(int,input().split()))
 
for t in targets:
  print(search(0,n-1,t,arr),end=' ')


