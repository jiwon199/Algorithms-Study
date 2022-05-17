from collections import deque
def bfs(maps):
    n=len(maps)
    m=len(maps[0])
     
    visited=[[1e9] *m for _ in range(n)]
    
    queue=deque()
    queue.append((0,0))
    visited[0][0]=1
    dx=[-1,1,0,0]
    dy=[0,0,-1,1]
     
    while queue:
        x,y=queue.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            
            if nx>=0 and ny>=0 and nx<n and ny<m:
                if maps[nx][ny]!=0 and visited[nx][ny]==1e9:
                    visited[nx][ny]=visited[x][y]+1
                    queue.append((nx,ny))
    if visited[n-1][m-1]==1e9:
        return -1
    else:
        return visited[n-1][m-1]
    
def solution(maps): 
    answer = bfs(maps)
    return answer
