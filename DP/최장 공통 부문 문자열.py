word1,word2=list(input().split())
 
n=len(word1)+1
m=len(word2)+1
arr=[[0]*n for _ in range(m)]
 
for i in range(1,m):
    for j in range(1,n):
        if word1[j-1]==word2[i-1]:
            arr[i][j]=arr[i-1][j-1]+1
ans=0
for res in arr:
    for num in res:
        if num>ans:
            ans=num
print(ans)
