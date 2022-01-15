def solution(d, budget):
    ans  = 0
    d=sorted(d)
    i=0
    while True :
        if i >len(d)-1:
            break
        budget-=d[i]
        if budget < 0:
            break
        i+=1
        ans+=1
    return ans
