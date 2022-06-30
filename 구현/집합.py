import sys
def add(x,data):
  data[x]=1
def remove(x,data):
  if data[x]==1 :
    data[x]=0
def check(x,data):
  print(data[x])
  
def toggle(x,data):
  if data[x]==1:
    data[x]=0
  else:
    data[x]=1
def all(data):
  for i in range(1,21):
    data[i]=1
def empty(data):
  for i in range(1,21):
    data[i]=0
  
data=dict()
for i in range(1,21):
  data[i]=0
n=int(sys.stdin.readline())

for _ in range(n):
  arr=sys.stdin.readline().split()
  if arr[0]=='all':
    all(data)
  elif arr[0]=='add':
    add(int(arr[1]),data)
  elif arr[0]=='remove':
    remove(int(arr[1]),data)
  elif arr[0]=='check':
    check(int(arr[1]),data)
  elif arr[0]=='toggle':
    toggle(int(arr[1]),data)
  elif arr[0]=='empty':
    empty(data)
  
