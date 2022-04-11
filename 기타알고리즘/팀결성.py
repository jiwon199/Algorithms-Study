#이코테 298p
def find_parent(parent,x):
  if parent[x]!=x:
    #x의 부모의 부모를 찾기
    parent[x]=find_parent(parent,parent[x])
  return parent[x]
# a랑 b가 연결되어 있다는 정보가 주어지면, 테이블에 a,b 관계를 기록.
def union_parent(parent,a,b):
  a=find_parent(parent,a)
  b=find_parent(parent,b)
  #a,b가 연결되어 있으면 숫자가 더 작은 쪽이 부모
  if a<b:
    parent[b]=a
  else:
    parent[a]=b
n,m=list(map(int,input().split())) 
#부모 테이블 초기화
parent=[0]*(n+1)

#부모 테이블상에서, 부모를 자기 자신으로 초기화
for i in range(0,n+1):
  parent[i]=i

#각 연산을 하나씩 확인
for i in range(m):
  oper,a,b=list(map(int,input().split()))
  #유니온 연산인 경우
  if oper==0:
    union_parent(parent,a,b)
  else:
    if find_parent(parent,a)==find_parent(parent,b):
      print("YES")
    else:
      print("NO")
