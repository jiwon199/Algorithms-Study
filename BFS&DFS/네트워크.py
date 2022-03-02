from collections import deque
def bfs(num,visited,n,computers):
    visited[num]=True
    queue=deque()
    queue.append(num)
    while queue:
        x=queue.popleft()
        for i in range(n):
            if computers[x][i]==1 and visited[i]==False:
                visited[i]=True
                queue.append(i)
def solution(n, computers):
    answer = 0
    visited=[False]*n
    for i in range(n):
        if visited[i]==False:
            bfs(i,visited,n,computers)             
            answer+=1    
    return answer
