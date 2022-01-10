#백준 1932
h=int(input())
array=[[] for _ in range(h)]
for i in range(h):  
  array[i]=list(map(int,input().split()))
 
for i in range(1,h):
  for j in range(len(array[i])):   
    if j==0:
      array[i][j]+=array[i-1][j]
    elif j==len(array[i-1]):
      array[i][j]+=array[i-1][j-1]
    else:     
      array[i][j]+=max(array[i-1][j],array[i-1][j-1])

print(max(array[h-1]))


 
