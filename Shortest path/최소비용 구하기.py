import sys
import heapq
#백준 1916
def dijkstra(start):
    q=[]
    heapq.heappush(q,(0,start))
    distance[start]=0
    while q:
        #방문하지 않은 노드 중 가장 거리가 짧은 now 반환 ()
        dist,now=heapq.heappop(q)
        #그렇게 뱉은 now까지의 거리/ 현재 기록된 now까지의 거리 비교
        #만약 기록된 거리가 더 짧으면 다음 루프로 넘어간다.
        if dist > distance[now]:
            continue
        #뱉어낸 now까지의 거리가 더 짧으면..
        #now에서 갈 수 있는 모든 경우를 검사
        #graph[now]에 (갈수 있는 곳, 거리) 순으로 줄줄히 기록되어있다.
        for i in graph[now]:
            cost=dist+i[1] #i[0]까지 거리+now까지 거리
            if cost < distance[i[0]]: #i[0]까지 거리가 distance에 기록된거 보다 짧으면 갱신
                distance[i[0]]=cost 
                #새롭게 루트가 갱신된 경우, 걔를 통해 새로운 루트가 또 생길 수 있으니 힙큐에 넣기
                heapq.heappush(q,(cost,i[0]))  
 
INF=int(1e9)
n =int(input())
m=int(input()) 

graph=[[] for _ in range(n+1)]
distance=[INF]*(n+1)

for i in range(m):
    a,b,c=list(map(int,sys.stdin.readline().split()))
    graph[a].append((b,c))
start,end=list(map(int,sys.stdin.readline().split()))
dijkstra(start)
print(distance[end])
