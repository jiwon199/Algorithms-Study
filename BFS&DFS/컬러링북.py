import sys
from collections import deque
def bfs(x,y ,m,n,visited):
	queue=deque()
	queue.append((x,y,picture[x][y]))
	visited[x][y]=True
	dx=[-1,1,0,0]
	dy=[0,0,-1,1]
	width=0
	while queue:
		tx,ty,col=queue.popleft()
		width+=1
		for i in range(4):
			nx=tx+dx[i]
			ny=ty+dy[i]
			if nx>=m or ny>=n or nx<0 or ny<0:
				continue
			if picture[nx][ny]!=col:
				continue
			if visited[nx][ny]==False:
				visited[nx][ny]=True
				queue.append((nx,ny,picture[nx][ny]))
				 
	return width
		
def solution(m, n, picture):
	answer = []
	visited=[[False]*n for _ in range(m)]
	count=0
	arr=[]
	for i in range(m):
		for j in range(n):
			if visited[i][j]==False and picture[i][j]!=0:
				arr.append(bfs(i,j,m,n,visited))
				count+=1
	 		
	return count,max(arr) #영역 몇 개 있는지, 가장 큰 영역이 몇 칸인지
