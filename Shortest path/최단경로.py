#백준 1753 (이론 참고-이코테 239p)
import sys
import heapq

def dijkstra(start):
    q=[]
    heapq.heappush(q,(0,start))
    distance[start]=0
    while q:
        dist,now=heapq.heappop(q)
        if dist > distance[now]:
            continue
        for i in graph[now]:
            cost=dist+i[1]
            if cost < distance[i[0]]:
                distance[i[0]]=cost
                heapq.heappush(q,(cost,i[0]))
INF=int(1e9)
n,m=list(map(int,sys.stdin.readline().split()))
start=int(sys.stdin.readline())

graph=[[] for _ in range(n+1)]
distance=[INF]*(n+1)

for i in range(m):
    a,b,c=list(map(int,sys.stdin.readline().split()))
    graph[a].append((b,c))

dijkstra(start)

for i in range(1,n+1):
    if distance[i]==INF:
        print("INF")
    else:
        print(distance[i])
