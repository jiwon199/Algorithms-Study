#이코테 197p 이진탐색 실전문제1
def binary_search(start,end,target,array):
  if start> end:
    return 'no'
  mid=(start+end)//2

  if array[mid]==target:
    return 'yes'
  elif array[mid]>target:
    return binary_search(start,mid-1,target,array)
  else:
    return binary_search(mid+1,end,target,array)
  
 
n=int(input())
array=list(map(int,input().split()))
m=int(input())
targets=list(map(int,input().split()))
  
for target in targets:
  print(binary_search(0,n-1,target,array),end=' ')


#집합 자료형으로 푸는 방법. 이 문제에서는 더 효과적이다.
'''
n=int(input())
array=set(map(int,input().split()))
m=int(input())
targets=list(map(int,input().split()))

for i in targets:
  if i in array:
    print('yes',end=' ')
  else:
    print('no',end=' ')
'''
