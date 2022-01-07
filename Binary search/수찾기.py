#백준 1920
import sys
def binary_search(array,start,end,target):  
  if start>end:
    return 0
  
  mid=(start+end)//2
  
  if target==array[mid]:
    return 1
  elif target<array[mid]:
     return binary_search(array,start,mid-1,target)
  else:
     return binary_search(array,mid+1,end,target)


n=int(sys.stdin.readline())
array=list(map(int,sys.stdin.readline().split()))
array=sorted(array)

m=int(sys.stdin.readline())

targets=list(map(int,sys.stdin.readline().split()))

for target in targets:
  print(binary_search(array,0,n-1,target))


 
