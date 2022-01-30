import heapq
def solution(scoville, K):
    answer = 0
    que=[]
    scoville=sorted(scoville)     
    
    for i in scoville:
        heapq.heappush(que,i)         
    while que:
        a=heapq.heappop(que)
        if a >= K:
            break    
        if not que:
            if a<K:
                answer=-1
            break
        b=heapq.heappop(que)           
        s=a+(b*2)        
        heapq.heappush(que,s)        
        answer+=1
    
    return answer
