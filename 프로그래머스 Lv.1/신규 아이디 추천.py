def solution(s):     
    s=s.lower()
    temp=''
    word=['~', '!','@','#','$','%','^' ,'&', '*' ,'(',')','=' ,'+' ,'[','{',']','}',':','?',',','<','>','/'] 
    for i in s:
        if i in word:
            continue
        else:
            temp+=i        
    s=temp
    temp=s[0]
    for i in range(1,len(s)):
        if temp[-1]=='.' and s[i]=='.':
            continue
        else:
            temp+=s[i]    
    s=temp       
    temp=''
    if s[0]=='.' and s[-1]=='.':
        s=s[1:len(s)-1]
    elif s[0]=='.':
        s=s[1:len(s)]
    elif s[-1]=='.':      
         s=s[0:len(s)-1]
    
    if len(s)==0:
        s='a'
        
    if len(s)>=16:
        s=s[0:15]
        if s[-1]=='.':
            s=s[0:14]
    while len(s)<=2:
        s+=s[-1]
        
    return s
