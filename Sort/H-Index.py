def checkH(h,c):
    count=0
    for i in c:
        if i>=h:
            count+=1
    if count>=h:
        return True
    else:
        return False
def solution(c):
    answer = 0
    c=sorted(c,reverse=True)    
    for i in range(c[0],0,-1):         
        if checkH(i,c):
            answer=i
            break
        
    return answer
