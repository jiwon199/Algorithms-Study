def solution(s):
    answer = ''
     
    data=s.split()
    number=['0','1','2','3','4','5','6','7','8','9']
    
    for i in range(len(data)):
        data[i]=data[i].lower()
        if data[i][0] not in number:
            alpa=data[i][0].upper()
            data[i]=alpa+ data[i][1:]
    blank=[]
    for i in range(1,len(s)):
        if s[i]==" ":
            if s[i-1]==" ":
                blank[-1]+=1
            else:
                blank.append(1) 
    blank.append(0)
    for i in range(len(data)):
        answer+=data[i]
        answer+=" "*blank[i]
    return answer
