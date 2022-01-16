def solution(s):     
    res=''
    num=['0','1','2','3','4','5','6','7','8','9']
    word=['zero','one','two','three','four','five','six','seven','eight','nine']
    data=dict()
    for i in range(10):
        data[word[i]]=num[i] 
        
    temp=''
    for i in s:    
        if i in num:             
            res+=i           
            temp=''
        else:
            temp+=i          
            if temp in word:
                res+=data[temp]
                temp=''     
    return int(res)
