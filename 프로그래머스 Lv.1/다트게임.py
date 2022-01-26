def getScore(s,b,o,score):
    if b=='D':
        s=s*s
    elif b=='T':
        s=s*s*s
    
    if o=='#':
        s=s*(-1)
    elif o=='*':
        if len(score)==0:
            s=s*2
        else:
            s=s*2
            score[-1]=score[-1]*2
        
    score.append(s)
    
         
    
def solution(d):
    answer = 0
    temp=''
    arr=[d[0]]
     
    for i in range(1,len(d)):
        if d[i] =='S' or d[i]=='D' or d[i]=='T' or d[i]=='*' or d[i]=='#':
            arr[-1]=arr[-1]+d[i]       
        else:
            if arr[-1]=='1':
                arr[-1]=arr[-1]+d[i] 
            else:
                arr.append(d[i]) 
    score=[]
    print(arr)
    for i in arr:         
        if len(i)==2:
            getScore(int(i[0]),i[1],'X', score)
        else:
            isten=i[0]+i[1]
            if isten!='10':
                getScore(int(i[0]),i[1],i[2],score)
            elif len(i)==4:
                getScore(10,i[2],i[3],score)
            else:
                getScore(10,i[2],'X',score)
            
    return sum(score)
