#백준 2869
a,b,v=list(map(int,input().split()))
m=v-a
 
if m%(a-b)==0:
  print(m//(a-b)+1)
else:
  print(m//(a-b)+2)
