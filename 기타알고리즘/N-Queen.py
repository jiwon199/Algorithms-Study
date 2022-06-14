n = int(input())
ans = 0
row = [0] * n
def is_promising(x):
    for i in range(x):
        #(x,?),(i,?) 이렇게놔서 같은 열에 있는경우 || (x,?) (x+y,?+y) 이렇게 돼서 대각선에 있는경우 
        if row[x] == row[i] or abs(row[x] - row[i]) == abs(x - i):
            return False    
    return True

def n_queens(x):
    global ans
    if x == n:
        ans += 1
        return

    else:
        for i in range(n):
            # [x, i]에 퀸을 놓겠다.
            row[x] = i
            if is_promising(x):
                n_queens(x+1)

n_queens(0)
print(ans)
