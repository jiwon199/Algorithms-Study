def solution(n, s, A, B, fares):
    answer = 100000*n
    INF=100000*n
    graph=[[INF]*(n+1) for _ in range(n+1)]
    for i in range(1,n+1):
        for j in range(1,n+1):
            if i==j:
                graph[i][j]=0
    for a,b,c in fares:
        graph[a][b]=min(graph[a][b],c)
        graph[b][a]=min(graph[a][b],c)     
    for k in range(1,n+1):
        for a in range(1,n+1):
            for b in range(1,n+1):
                temp=graph[a][k]+graph[k][b]
                if temp>graph[a][b]:
                    temp=graph[a][b]                
                graph[a][b]=temp
                graph[b][a]=temp   
    #헤어지는 지점이 i라고 가정
    for i in range(1,n+1):
        temp=graph[s][i]+graph[i][A]+graph[i][B]
        if temp<answer:
            answer=temp
    return answer
