from itertools import combinations
def isPrime(n):
    if n==2 or n==3 or n==5 or n==7:
        return True
    else:
        for i in range(2,n//2+1):
            if n%i==0:
                return False
            else:
                continue
        return True
    
def solution(nums):
    
    ans=0
    combi = list(combinations(nums, 3))
    
    for i in combi:
        a,b,c=i
        if isPrime(a+b+c):
            ans+=1
        
            
    return ans
