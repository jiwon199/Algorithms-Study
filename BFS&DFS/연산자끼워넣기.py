#백준 14888
n=int(input())
Aarr=list(map(int,input().split()))
data=list(map(int,input().split()))

def dfs(depth,plus,minus,multi,divi,res):
  if depth==n:
    ans.append(res)
    return 
  else:
    if plus>=1:
      dfs(depth+1,plus-1,minus,multi,divi,res+Aarr[depth])
    if minus>=1:
      dfs(depth+1,plus,minus-1,multi,divi,res-Aarr[depth])
    if multi>=1:
      dfs(depth+1,plus,minus,multi-1,divi,res*Aarr[depth])
    if divi>=1:
      temp=abs(res)//Aarr[depth]
      if res<=0:
        dfs(depth+1,plus,minus,multi,divi-1,-temp)
      else:
        dfs(depth+1,plus,minus,multi,divi-1,temp)
    
ans=[]
dfs(1,data[0],data[1],data[2],data[3],Aarr[0])
ans=sorted(ans)
print(ans[-1])
print(ans[0])
