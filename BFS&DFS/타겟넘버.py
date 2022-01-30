from collections import deque
def dfs(n,index,before,ans):    
    if len(n)-1==index:         
        ans.append(before-n[index])  
        ans.append(before+n[index])          
        return 0  
    else:        
        dfs(n,index+1,before+n[index],ans)
        dfs(n,index+1,before-n[index],ans)
                
def solution(numbers, target):
    answer=0
    ans=[]
    ans1=dfs(numbers,1,numbers[0],ans)
    ans2=dfs(numbers,1,-numbers[0],ans)
    print(len(ans))
    return ans.count(target)
