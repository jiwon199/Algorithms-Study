def solution(triangle):
     
    height=len(triangle)
    dp=[[triangle[0][0]]]  
    for row in range(1,height):
        temp=[]
        #triangle[row]를 보자
        #triangle[row]의 길이는 row+1이겠지.
        for i in range(row+1):
             
            if i==0:
                temp.append(dp[row-1][0]+triangle[row][i])
            elif i==row:                 
                temp.append(dp[row-1][-1]+triangle[row][i])
            else:
                temp.append(max(dp[row-1][i],dp[row-1][i-1])+triangle[row][i])
        
        dp.append(temp) 
     
    return max(dp[-1])
