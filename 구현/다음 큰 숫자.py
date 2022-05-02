def makeTwo(n):
    count=0
    while True:
        if n==1:           
            count+=1
            break
        elif n==0:            
            break
        if n%2==1:
            count+=1
        n=n//2
    return count
 
def solution(n):
    answer = n
    a=makeTwo(n)
    
    while True:
        answer=answer+1
        b=makeTwo(answer)
        if a==b :
            break   
    return answer
