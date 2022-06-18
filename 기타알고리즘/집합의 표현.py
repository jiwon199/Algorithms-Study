#qorwns 1717
import sys
sys.setrecursionlimit(10**6)
def union(parent,a,b):
  a=find_parent(a,parent)
  b=find_parent(b,parent)
  if a>b:
    parent[a]=b    
  else:
    parent[b]=a
 
def find_parent(x,parent):
    if parent[x] != x:
        parent[x] = find_parent(parent[x], parent)
    return parent[x]
n,m=map(int, sys.stdin.readline().split())
parent=[i for i in range(n+1)]
for _ in range(m):
  oper,a,b=map(int, sys.stdin.readline().split())
  if oper==0:
    union(parent,a,b)
  else:
    if find_parent(a,parent)==find_parent(b,parent):
      print('YES')
    else:
      print('NO')
 
 
