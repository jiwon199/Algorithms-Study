import heapq
def find_path(K,graph,distance):
     
    count=0
    q=[]
    heapq.heappush(q,(0,1))
    distance[1]=0
    while q:
        dist,now=heapq.heappop(q)
        if dist>distance[now]:
            continue
        for node,w in graph[now]:
            cost=dist+w
            if cost<distance[node]:
                distance[node]=cost
                heapq.heappush(q,(cost,node))   
    print(distance[1:])
    for w in distance:
        if w<=K:             
            count+=1
    return count
    
def solution(N, road, K):
     
    INF=1e9
    distance=[INF]*(N+1) 
    graph=[[] for _ in range(N+1)]
    for a,b,c in road:
        graph[a].append((b,c))
        graph[b].append((a,c))
        
    answer=find_path(K,graph,distance)
    

    return answer
