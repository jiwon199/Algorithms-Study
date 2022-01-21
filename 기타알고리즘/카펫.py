def numyellow(x,n):
    brown=x[0]*2+x[1]*2-4
    return n-brown
def solution(brown, yellow):
    answer = []
    arr=set()
    n=brown+yellow
    for i in range(2,n//2):
        if n%i==0 and n//i>=i:
            arr.add((n//i,i))
    for i in arr:
         if numyellow(i,n)==yellow:
                answer=i
        
    return answer
