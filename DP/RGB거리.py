#백준 1149
h=int(input())
array=[[] for _ in range(h)]
for i in range(h):  
  array[i]=list(map(int,input().split()))
 
for i in range(1,h):
  for j in range(3):
    if j==0:
      array[i][j]+=min(array[i-1][1],array[i-1][2])
    elif j==1:
      array[i][j]+=min(array[i-1][0],array[i-1][2])
    else:
      array[i][j]+=min(array[i-1][0],array[i-1][1])
 
print(min(array[h-1]))
