from itertools import permutations
def goDungeons(sleepy,k):
    if sleepy<=k:
        return True
    else:
        return False

    #0,1,2
def countDungeons(order,k,dungeons):
    count=0
    state=k
    for i in order: 
        if goDungeons(dungeons[i][0],state)==True:
            state-=dungeons[i][1]    
            count+=1
        else:
            continue
    return count
def solution(k, dungeons):
     
    n=len(dungeons)
    arr=[i for i in range(n)]
    orders=list(permutations(arr,n))
    res=[]
    for order in orders:
        res.append(countDungeons(order,k,dungeons))
        
    return max(res)
