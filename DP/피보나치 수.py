def solution(n):
    answer = 0
    dp=[0,1]
    for i in range(2,n+1):
        n=dp[i-1]+dp[i-2]
        dp.append(n%1234567)
    #print(dp[-1])
    return dp[-1]
