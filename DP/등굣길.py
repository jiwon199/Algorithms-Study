def isPuddle(x,y,pud):
    if pud[x][y]==-1:
        return True
    else:
        return False
def solution(m, n, puddles):
    answer = 0
    graph=[[0]*m for _ in range(n)]
    pud=[[0]*m for _ in range(n)]
    for puddle in puddles:
        pud[puddle[1]-1][puddle[0]-1]=-1
    
    graph[0][1]=1
    graph[1][0]=1
     
    for i in range(n):
        for j in range(m):
            print()
             
            if isPuddle(i,j,pud):
                graph[i][j]=0
                continue             
            elif (i==0 and j==0) or (i==0 and j==1) or (i==1 and j==0):
                continue    
                   
            if i==0:
                graph[i][j]=graph[i][j-1]
            elif j==0:
                graph[i][j]=graph[i-1][j]
            else:
                graph[i][j]=graph[i-1][j]+graph[i][j-1]
                
    return graph[n-1][m-1]% 1000000007
