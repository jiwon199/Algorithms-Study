def solution(num): 
    arr=[]
    for i in num:
        j=str(i)
        if len(j)==1:
            arr.append((j+j+j+j,1))
        elif len(j)==2:
            arr.append((j[0]+j[1]+j[0]+j[1],2))
        elif len(j)==3:
            arr.append((j[0]+j[1]+j[2]+j[0],3))
        else:
            arr.append((j[0]+j[1]+j[2]+j[3],4))
    arr=sorted(arr,reverse=True)     
    ans=''
    for i in arr:
        ans+=i[0][:i[1]]
    temp=int(ans)
    return str(temp)
