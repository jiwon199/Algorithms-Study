def solution(record):
    answer = []
    arr=[]
    for r in record:
        temp=r.split()
        arr.append(temp)
    data=dict()
    for a in arr:    
        if a[0]=="Enter" or a[0]=="Change":
            data[a[1]]=a[2]   
    for a in arr:
        if a[0]=="Enter":
            s=data[a[1]]+"님이 들어왔습니다."
            answer.append(s)
        elif a[0]=="Leave":
            s=data[a[1]]+"님이 나갔습니다."
            answer.append(s)
        
    return answer
