def solution(clothes):
    answer = 1
    data=dict()
    for i in clothes:
        if i[1] in data.keys():
            data[i[1]].append(i[0])
        else:
            data[i[1]]=[i[0]]    
    value_list=data.values()   
    key_list=data.keys()
    for i in key_list:              
        answer=answer*(len(data[i])+1)
    return answer-1
