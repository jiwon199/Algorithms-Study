def makeNum(x,ans):       
    if x<=0:         
        return ans
    if x%3==0:
        return makeNum(x//3-1,ans+"4")
    else:
        return makeNum(x//3,ans+str(x%3))
def solution(n):
    answer = ''
    ans=''
    ans=makeNum(n,ans)
    for i in range(len(ans)-1,-1,-1):
        answer+=ans[i]
    return answer
