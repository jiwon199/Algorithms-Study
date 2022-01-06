#이코테 180p 정렬 실전문제2
n=int(input())
arrays=[]
for i in range(n):
  data=list(input().split())
  arrays.append((data[0],int(data[1])))

 
arrays=sorted(arrays,key=lambda data:data[1])

for i in arrays:
  print(i[0],end=' ')
