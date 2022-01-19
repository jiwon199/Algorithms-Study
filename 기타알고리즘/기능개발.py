def solution(progresses, speeds):
    stack=[]
    speed=[]
    ans=[]
    for i in range(len(progresses)-1,-1,-1):
        stack.append(progresses[i])
        speed.append(speeds[i])  
    while True:
        if len(stack)==0:
            break
        for i in range(len(stack)):
            stack[i]+=speed[i]
        temp=0
        while True:
            if len(stack)==0:
                break
            elif stack[-1]<100:
                break
            else:
                stack.pop()
                speed.pop()
                temp+=1
        if temp!=0:
            ans.append(temp)
        
        
    return ans
