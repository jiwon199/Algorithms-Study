def solution(id_list, report, k):
    r=set()
    data=dict()
    for i in report:
        a,b= i.split()
        r.add((a,b))
    for i in r:
        if i[1] in data.keys():
            data[i[1]]+=1
        else:
            data[i[1]]=1
    ans=dict()
    for i in id_list:
        ans[i]=0
    for i in r:
        if i[1] in data.keys() and data[i[1]]>=k: 
            ans[i[0]]+=1
    answer=[]        
    for i in id_list:
        answer.append(ans[i])
    return answer
