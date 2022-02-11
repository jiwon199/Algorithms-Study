import heapq
def solution(f, k):
    l=len(f)
    queue=[]
    for i in range(l):
        heapq.heappush(queue,[f[i],i+1])
    time=0 
    length=len(queue)
    now=0
    previous=0
    while queue:                 
        if time+(queue[0][0]-previous)*length>k:
            break
        now=heapq.heappop(queue)
        time+=(now[0]-previous)*length
        length-=1
        previous=now[0]   
         
    queue.sort(key=lambda x:(x[1],x[0]))
    
    if not queue:
        return -1    
    else:
        return queue[(k-time)%length][1]
