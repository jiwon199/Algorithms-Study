def check(n,data):
    for i in range(2,1000):
        if n%i==0 and i!=n:
            data[n]+=1
            
def solution(left, right):
    ans = 0
    data=dict()
    data[1]=1
    for i in range(2,right+1):
        data[i]=2
        check(i,data)
        
    for i in range(left, right+1):
        if data[i] % 2==0:
            ans+=i
        else:
            ans-=i    
    return ans
