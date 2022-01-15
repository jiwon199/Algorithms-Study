def solution(s):
    ans = ''
    if len(s) %2==0:         
        ans+=s[len(s)//2-1]
        ans+=s[len(s)//2]
    else:
        ans+=s[len(s)//2]
    return ans 
