def solution(n):
    answer = 0
    data=[(i+1) for i in range(n)]
    
    for start in range(n):
        res=data[start]
        end=start+1
        while res<n:
            res+=data[end]
            end+=1
        
        if res==n:
            answer+=1
    return answer
