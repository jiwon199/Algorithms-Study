def Collatz(x,count):
    if x==1:
        return count
    if count==500:
        return -1
    if x%2==0:
        return Collatz(x//2,count+1)
    else:
        return Collatz(x*3+1,count+1)
    
def solution(num):
    answer = Collatz(num,0)
    return answer
