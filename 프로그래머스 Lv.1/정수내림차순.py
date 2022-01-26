def solution(n):
    answer = ''    
    arr=[]
    for i in str(n):
        arr.append(i)    
    arr=list(map(int,arr))
    arr=sorted(arr,reverse=True)
     
    for i in arr:        
        answer+=str(i)    
    return int(answer)
