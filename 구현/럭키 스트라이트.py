#백준 18406
import sys
n=sys.stdin.readline()
l=len(n)//2
a=n[:l]
b=n[l:]

sum1=0
sum2=0
for i in range(l):
  sum1+=int(a[i])
  sum2+=int(b[i])

if sum1==sum2:
  print("LUCKY")
else:
  print("READY")
