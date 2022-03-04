#백준 10828
import sys
n = int(sys.stdin.readline())
stack = []
for i in range(n):
    arr = list(sys.stdin.readline().split())
    if arr[0] == "push":
        stack.append(int(arr[1]))
    elif arr[0] == "pop":
        if len(stack) >= 1:
            print(stack.pop(-1))
        else:
            print(-1)
    elif arr[0] == "size":
        print(len(stack))
    elif arr[0] == "empty":
        if len(stack) == 0:
            print(1)
        else:
            print(0)
    else:
        if len(stack) == 0:
            print(-1)
        else:
            print(stack[-1])
