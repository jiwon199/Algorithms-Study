#이코테 149p 그래프 실전문제1

# DFS로 특정한 노드를 방문한 뒤에 연결된 모든 노드들도 방문
def dfs(x, y):
    # 주어진 범위를 벗어나는 경우에는 즉시 종료
    # x: 0~n-1, y:0~m-1
    if x <= -1 or x >= n or y <= -1 or y >= m:
        return False
    # 현재 노드를 아직 방문하지 않았다면
    if graph[x][y] == False:
        # 해당 노드 방문 처리
        graph[x][y] = True
        # 상, 하, 좌, 우의 위치들도 모두 재귀적으로 호출
        dfs(x - 1, y)
        dfs(x, y - 1)
        dfs(x + 1, y)
        dfs(x, y + 1)
        return True
    return False

n,m=list(map(int,input().split()))

graph=[]
for i in range(n):
  graph.append(list(map(int,input())))

#0은 false, 1은 true
# 모든 노드(위치)에 대하여 음료수 채우기
result = 0
for i in range(n):
    for j in range(m):
        # 현재 위치에서 DFS 수행. 
        '''
         true인 걸 세는 이유... 
         graph(x,y)가 0인 위치가 호출되면 true임.
         근데 이런 애가 한 번 호출되면 재귀함수호출로 인해 인접한 애들을 다 1로 만들어버림. 
         그래서 0의 뭉치들 중 아래 if문에 걸리는 애는 하나밖에 없다. 
         그러므로 0의 뭉텅이들을 세기 위해 if문을 이렇게 쓰는 것. 
        '''       
        if dfs(i, j) == True:
            result += 1

print(result) # 정답 출력
