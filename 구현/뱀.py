#백준 3190  
from collections import deque

n = int(input())
k = int(input())

# 뱀이 움직일 좌표
graph = [[0] * (n + 1) for _ in range(n + 1)]

# 사과 위치 표현
for _ in range(k):
    a, b = map(int, input().split())
    graph[a][b] = 1

# 동, 남, 서, 북 순서 왼쪽이면 -1, 오른쪽이면 +1해서 인덱스 변환으로 방향 조절
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
now_direction = 0


# 방향 전환 함수
def change_diretion(change):
    global now_direction

    if change == 'L':
        now_direction -= 1
        if now_direction < 0:
            now_direction = 3
    elif change == 'D':
        now_direction += 1
        if now_direction > 3:
            now_direction = 0


# 방향 변환 변수, 시간당 방향 변환 정보 입력
time_index = 0
time_data = []
l = int(input())
for _ in range(l):
    time_data.append(list(map(str, input().split())))

# 현재시간, 뱀의 좌표, 덱 리스트 변환용 변수, 탈출용 boolean 변수, 사과 여부 변수
time = 0
snake = deque([[1, 1]])
temp = []

# 게임 끝나는지 여부 체크 함수
def check(nx, ny, temp, length):
    global n
    escape = 0
    if nx < 1 or nx > n or ny < 1 or ny > n:
        escape = 1
    if length > 1:
        for i in range(length - 1):
            if nx == temp[i][0] and ny == temp[i][1]:
                escape = 2
    return escape


while True:
    # deque 리스트 변환, 뱀의 머리 부분 좌표 설정(x, y)
    temp = list(snake)
    x, y = temp[-1][0], temp[-1][1]

    # 시간 증가
    time += 1

    # 뱀의 이동 규칙 적용
    nx = x + dx[now_direction]
    ny = y + dy[now_direction]
    if check(nx, ny, temp, len(snake)):
        break
    snake.append([nx, ny])

    if 1 <= nx and nx <= n:
        if 1 <= ny and ny <= n:
            if graph[nx][ny] == 1:
                graph[nx][ny] = 0
            else:
                snake.popleft()


    # 방향 변환
    if time_index < l:
        if time == int(time_data[time_index][0]):
            change_diretion(time_data[time_index][1])
            time_index += 1

print(time)
