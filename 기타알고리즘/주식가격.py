
def solution(prices):
    answer = []
    arr=[]
    n=len(prices)
    for start in range(n):
        end=start
        count=0
        while prices[start]<=prices[end]:
            end+=1
            if end>=n:
                break
            count+=1
        answer.append(count)
            
    return answer
