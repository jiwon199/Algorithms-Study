def zipS(s,l):
    temp=[]    
    word=''
    length=0
    for i in s:    
        word+=i
        if len(word)==l:           
            temp.append(word)             
            word='' 
    if word!='':
        temp.append(word)
    num=1
    ans=''
     
    arr=[[temp[0],1]]
    for i in range(1,len(temp)):
        if temp[i]==arr[-1][0]:
            arr[-1][1]+=1
        else:
            arr.append([temp[i],1])
    
    for i in arr:
        if i[1]==1:
            ans+=i[0]
        else:
            ans+=str(i[1])+i[0]
     
    return len(ans)
def solution(s):
    answer = 0
    l=len(s)
    ans=[]
    zipS(s,1)
    for i in range(1,l+1):
        length=zipS(s,i)        
        ans.append(length)
    ans=sorted(ans)
     
    
        
    return ans[0]
