import math
def isPrime(k,sosu):
    if k==2 or k==3 or k==5 or k==7:
        return True
    elif k%2==0:
        return False        
    else:  
        for i in sosu:
            if i > int(math.sqrt(k)):
                return True
            if k%i==0:
                return False   
        return True
def solution(n):
    ans = 0
    sosu=[]  
    for i in range(2,n+1):
        if isPrime(i,sosu):          
            ans+=1
            sosu.append(i)
        
    return ans
