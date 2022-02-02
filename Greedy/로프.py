#백준 2217
n=int(input())
arr=[]
for i in range(n):
  arr.append(int(input()))

arr=sorted(arr,reverse=True)
res=[]
for i in range(n):
  res.append(arr[i]*(i+1))
print(max(res))
