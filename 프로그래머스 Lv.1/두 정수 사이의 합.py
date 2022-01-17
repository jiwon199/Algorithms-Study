def solution(a, b):    
    if a>b: 
        a,b=b,a
    arr=[i for i in range(a,b+1)]
    return sum(arr)
