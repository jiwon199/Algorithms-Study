#백준 1620
n,m=list(map(int,input().split()))
dataInt=dict()
dataStr=dict()
for i in range(1,n+1):
  word=input()  
  dataInt[str(i)]=word
  dataStr[word]=i
 
for i in range(m):
  word=input()
  if word.isdigit()==True:
    print(dataInt[word])
  else:
    print(dataStr[word])
