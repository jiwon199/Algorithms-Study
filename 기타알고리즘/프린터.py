from collections import deque
def solution(priorities, location):
    answer = 0
    ans=[]
    queue=deque()
    
    for i in range(len(priorities)):
        queue.append((i,priorities[i]))
        
    while queue:
        a=queue.popleft()
        flag=False
        for i in queue:
            if i[1]>a[1]:
                flag=True
        if flag:
            queue.append(a)
        else:
            ans.append(a)
            
    for i in range(0,len(ans)):
        if ans[i][0]==location:
            answer=i+1
        
    return answer
