def findNum(w,h):
    s=0
    if w>h:
        s=h
    else:
        s=w
    res=1
    for i in range(2,s+1):
        if w%i==0 and h%i==0:
            res=i
    return res
def solution(w,h):
     
    n=findNum(w,h)
    #잘리는 사각형 개수: w+h-g
    answer=w*h-(w+h-n)
       
    return answer
