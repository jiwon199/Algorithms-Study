def solution(n, lost, reserve):  
    temp=[]
    for r in lost:
        if r in reserve: 
            temp.append(r)
    lost=sorted(lost)
    reserve=sorted(reserve)
    for i in temp:
        lost.remove(i)
        reserve.remove(i)
    
    lost=sorted(lost)
    reserve=sorted(reserve)
    for i in range(len(reserve)):
        if reserve[i]-1 in lost:
            lost.remove(reserve[i]-1) 
        elif reserve[i]+1 in lost:
            lost.remove(reserve[i]+1)     
    return n-len(lost)
