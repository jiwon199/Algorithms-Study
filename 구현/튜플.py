def find(before,current,answer):
    l=len(current)
    for i in range(l):
        if current[i] in answer:
            continue
        else:
            answer.append(current[i])
def solution(s):
    answer = []
    array=[]
    s=s.split('}')
    s[0]=s[0][2:]
    
    s2=''
    for arr in s:
        for i in arr:
            s2+=i
    s2=s2.split('{')
    setarr=[]
    for arr in s2:
        temp=[]
        arr=arr.split(',')
         
        for a in arr:
            if a!='': 
                temp.append(int(a))
        setarr.append((len(temp),temp))   
    setarr=sorted(setarr)
    answer.append(setarr[0][1][0])
     
    for i in range(1,len(setarr)):
        find(setarr[i-1][1],setarr[i][1],answer)
    
    return answer 
