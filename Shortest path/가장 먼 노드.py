from collections import deque
from collections import defaultdict
def solution(n, edge):
    
    data=defaultdict(list)
    for a,b in edge:
        data[a].append(b)
        data[b].append(a)   
    queue=deque()
    queue.append(1)
    visited=[False]*(n+1)
    distance=[0]*(n+1)
    distance[1]=0
    visited[1]=True
    while queue:
        num=queue.popleft()
        for i in data[num]:
            if visited[i]==False:
                distance[i]=distance[num]+1
                visited[i]=True
                queue.append(i)
            
               
    res=max(distance)
    answer=0
    for i in range(1,n+1):
        if distance[i]==res:
            answer+=1     
    return answer
