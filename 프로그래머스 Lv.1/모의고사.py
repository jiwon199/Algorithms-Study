def solution(answers):
    ans = [0,0,0]
    a=[1,2,3,4,5] #5
    b=[2,1,2,3,2,4,2,5] #8
    c=[3,3,1,1,2,2,4,4,5,5] #10
    index=0
    for x in answers:
        if a[index%5]==x:
            ans[0]+=1
        if b[index%8]==x:
            ans[1]+=1
        if c[index%10]==x:
            ans[2]+=1
        index+=1
    
    maxval=max(ans)
    answer=[]
    for i in range(1,4):
        if ans[i-1] >= maxval:
            answer.append(i)     
    return answer
