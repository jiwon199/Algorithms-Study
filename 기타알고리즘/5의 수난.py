#백준 23037
s=input()
answer=0
for i in s:
  n=int(i)
  answer+=(n*n*n*n*n)
print(answer)
