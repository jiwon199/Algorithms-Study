#이코테 178p 정렬 실전문제1
n=int(input())
arrays=[]
for i in range(n):
  arrays.append(int(input()))

arrays=sorted(arrays,reverse=True)


for i in range(n):
  print(arrays[i],end=' ')

