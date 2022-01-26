def makeTwo(i,x,n):
    if len(x)==n:
        return x
    else:
        x+=str(i%2)
        return makeTwo(i//2,x,n)
def solution(n, arr1, arr2):
    answer = []
     
    map1=[]
    for i in arr1:
        s=makeTwo(i,'', n)
        map1.append(s[::-1])
    map2=[]
    for i in arr2:
        s=makeTwo(i,'', n)
        map2.append(s[::-1])
    for (a,b) in zip(map1,map2):
        temp=''
        for i in range(n):
            if a[i]=='0' and b[i]=='0':
                temp+=" "
            else:
                temp+="#"
        answer.append(temp)
        temp=''
             
    return answer
