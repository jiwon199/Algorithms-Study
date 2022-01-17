def solution(s, n):    
    s=sorted(s)
    s=sorted(s,key=lambda x: x[n])
    return s
