#백준 1439
import sys
s=sys.stdin.readline()
count=0
for i in range(1,len(s)):
  if s[i-1]!=s[i]:
    count+=1

print(count//2)
