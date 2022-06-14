def solution(n):
    answer = 0
    dp=[1,2]
    for i in range(1,n):
        dp.append((dp[i]+dp[i-1])%1000000007)
         
    return dp[n-1]
