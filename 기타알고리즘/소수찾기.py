from itertools import permutations
def makeNum(x):
    number=''
    for i in x:
        number+=i
    return int(number)
def isPrime(n):
    if n==2 or n==3 or n==5 or n==7:
        return True
    elif n%2==0 or n==1:
        return False
    else:
        for i in range(3,n-1):
            if n%i==0:
                return False
        return True
def solution(s):
    answer = 0   
    arr=set()
    for i in range(1,len(s)+1):
        res=list(map(makeNum,permutations(s,i)))
        number=''
        for j in res:
            arr.add(j)     
    for i in arr:         
        if isPrime(i)==True:              
            answer+=1
    return answer
